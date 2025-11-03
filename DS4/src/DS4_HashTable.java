import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K, V> implements DS4_HashTable_Interface <K, V> {
    private int bucketCapacity;
    private int loadFactor;
    private int tableSize;
    private ArrayList<ArrayList<DS4_Entry<K, V>>> yo;

    public DS4_HashTable(int bucketCapacity,int loadFactor, int tableSize){
        yo = new ArrayList<>();
        this.bucketCapacity = bucketCapacity;
        this.loadFactor = loadFactor;
        this.tableSize = tableSize;
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
        return 0;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V insert(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    public Iterator<K> iterator() {
        ArrayList<K> wow = new ArrayList<>();
        return wow.iterator();
    }
}
