
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public interface DS4_HashTable_Interface<K, V> {

    public void clear();
    public int size();
    public int tombstones();

    boolean contains(K key);
    public V insert(K key, V value);

    V remove(K key);

}
