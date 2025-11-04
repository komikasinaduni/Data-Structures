<<<<<<< Updated upstream
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
=======
public class DS4_HashTable<E> implements DS4_HashTable_Interface<E> {
    @Override
    public void clear() {

>>>>>>> Stashed changes
    }

    @Override
    public int size() {
<<<<<<< Updated upstream
        return yo.size();
=======
        return 0;
>>>>>>> Stashed changes
    }

    @Override
    public int tombstones() {
        return 0;
    }

    @Override
<<<<<<< Updated upstream
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
=======
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Object insert(Object key, Object value) {
        return null;
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }
>>>>>>> Stashed changes
}
