import java.util.ArrayList;

public class DS4_HashTable<Integer, V> implements DS4_HashTable_Interface<Integer, V>{
    private int bucketCapacity;
    private int loadFactor;
    private int tableSize;
    private int tombstones;
    private ArrayList<ArrayList<DS4_Entry<Integer, V>>> yo;

    public DS4_HashTable(int bucketCapacity,int loadFactor, int tableSize){
        yo = new ArrayList<>();
        this.bucketCapacity = bucketCapacity;
        this.loadFactor = loadFactor;
        this.tableSize = tableSize;
        tombstones = 0;
    }

    @Override
    public void clear() {
        yo.clear();
    }

    @Override
    public int size() {
        return yo.size();
    }

    @Override
    public int tombstones() {
        return tombstones;
    }

    @Override
    public boolean contains(Integer key) {
        return false;
    }

    @Override
    public V insert(Integer key, V value) {
        int hi = (int)key;
        for(int i = 0; i<(hi % tableSize); i++){
            yo.add(new ArrayList<DS4_Entry<Integer, V>>());
        }
        for(int i = 0; i<)
    }

    @Override
    public V remove(Integer key) {
        V value = null;
        for(int i = 0; i<yo.size(); i++){
            for(int j = 0; j<yo.get(i).size(); j++){
                if(yo.get(i).get(j).equals(key)){
                    value = (V) yo.get(i).get(j);
                    yo.get(i).set(j, null);
                }
            }
        }
        tombstones++;
        return value;
    }
}
