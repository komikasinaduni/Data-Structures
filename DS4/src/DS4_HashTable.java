import java.util.ArrayList;
import java.util.Iterator;
public class DS4_HashTable<K, V> implements DS4_HashTable_Interface<K, V> {
    private int bucketCapacity;
    private int loadFactor;
    private int tableSize;
    private int tombstones;
    private int size;
    private ArrayList<ArrayList<DS4_Entry<K, V>>> yo;

    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize) {
        this.bucketCapacity = bucketCapacity;
        this.loadFactor = loadFactor;
        this.tableSize = tableSize;
        this.tombstones = 0;
        this.size = 0;
        yo = new ArrayList<>();
        for (int i = 0; i<tableSize; i++){
            yo.add(new ArrayList<>());
        }
    }

    @Override
    public void clear() {
        yo.clear();
        for (int i = 0; i<tableSize; i++){
            yo.add(new ArrayList<>());
        }
        size = 0;
        tombstones = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int tombstones() {
        return tombstones;
    }

    private int hash(K key) {
        int hash = Math.abs(key.hashCode())%tableSize;
        return hash;
    }

    @Override
    public boolean contains(K key) {
        int wow = hash(key);
        int cb = 0;
        while (cb < tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(wow);
            for (DS4_Entry<K, V> entry : bucket) {
                if (entry != null && entry.key.equals(key)) {
                    return true;
                }
            }
            if (bucket.size() < bucketCapacity)
                return false;
            wow = (wow + 1) % tableSize;
            cb++;
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        int wow = hash(key);
        int cb = 0;
        while (cb<tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(wow);
            for (int i = 0; i < bucket.size(); i++) {
                DS4_Entry<K, V> entry = bucket.get(i);
                if (entry != null && entry.key.equals(key)) {
                    V oldValue = entry.value;
                    bucket.set(i, new DS4_Entry<>(key, value));
                    return oldValue;
                }
            }
            if (bucket.size() < bucketCapacity) {
                bucket.add(new DS4_Entry<>(key, value));
                size++;
                if ((size+tombstones)>=loadFactor) {
                    rebuild();
                }
                return null;
            }
            wow = (wow+1)%tableSize;
            cb++;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int wow = hash(key);
        int yo2 = 0;
        while (yo2<tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(wow);
            for (int i = 0; i<bucket.size(); i++){
                DS4_Entry<K, V> first = bucket.get(i);
                if (first!=null&&first.key.equals(key)) {
                    V old = first.value;
                    bucket.set(i, null);
                    tombstones++;
                    size--;
                    return old;
                }
            }
            if (bucket.size() < bucketCapacity)
                return null;
            wow = (wow+1)%tableSize;
            yo2++;
        }

        return null;
    }
    private void rebuild() {
        ArrayList<DS4_Entry<K, V>> all = new ArrayList<>();
        for(int i = 0; i<yo.size(); i++){
            for(int j = 0; j<yo.get(i).size(); j++){
                if(yo.get(i).get(j)!=null){
                    all.add(yo.get(i).get(j));
                }
            }
        }
        tableSize*= 2;
        loadFactor*= 2;
        tombstones = 0;
        size = 0;
        yo.clear();
        for (int i = 0; i<tableSize; i++){
            yo.add(new ArrayList<>());
        }
        for(int i = 0; i<all.size(); i++){
            insert(all.get(i).key, all.get(i).value);
        }
    }

    public Iterator<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i<yo.size(); i++){
            for(int j = 0; j<yo.get(i).size(); j++){
                if (yo.get(i).get(j)!= null)
                    keys.add(yo.get(i).get(j).key);
            }
        }
        return keys.iterator();
    }

    @Override
    public String toString() {
        String s = "{";
        for (int i = 0; i<yo.size(); i++) {
            for(int j = 0; j<yo.get(i).size(); j++){
                if(i!=yo.size()-1 && j!=yo.get(i).size()-1){
                    s+=yo.get(i).get(j).key + "=" + yo.get(i).get(j).value + ", ";
                }
                else{
                    s+=yo.get(i).get(j).key + "=" + yo.get(i).get(j).value + "}";
                }
            }
        }
        return s;
    }

    public int tableSize(){
        return tableSize;
    }

}