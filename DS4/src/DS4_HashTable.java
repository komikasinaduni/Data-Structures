import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K, V> implements DS4_HashTable_Interface<K, V> {
    private int bucketCapacity;
    private int loadFactor;
    private int tableSize;
    private int tombstones;
    private int itemCount;
    private ArrayList<ArrayList<DS4_Entry<K, V>>> yo;

    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize) {
        this.bucketCapacity = bucketCapacity;
        this.loadFactor = loadFactor;
        this.tableSize = tableSize;
        this.tombstones = 0;
        this.itemCount = 0;
        yo = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            yo.add(new ArrayList<>());
        }
    }

    @Override
    public void clear() {
        yo.clear();
        for (int i = 0; i < tableSize; i++) {
            yo.add(new ArrayList<>());
        }
        itemCount = 0;
        tombstones = 0;
    }

    @Override
    public int size() {
        return itemCount;
    }

    @Override
    public int tombstones() {
        return tombstones;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % tableSize;
    }

    @Override
    public boolean contains(K key) {
        int index = hash(key);
        int checkedBuckets = 0;

        while (checkedBuckets < tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(index);
            for (DS4_Entry<K, V> entry : bucket) {
                if (entry != null && entry.key.equals(key)) {
                    return true;
                }
            }
            if (bucket.size() < bucketCapacity)
                return false;
            index = (index + 1) % tableSize;
            checkedBuckets++;
        }
        return false;
    }

    @Override
    public V insert(K key, V value) {
        int index = hash(key);
        int checkedBuckets = 0;

        while (checkedBuckets < tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(index);
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
                itemCount++;
                if ((itemCount + tombstones) >= loadFactor) {
                    rebuild();
                }
                return null;
            }
            index = (index + 1) % tableSize;
            checkedBuckets++;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        int checkedBuckets = 0;

        while (checkedBuckets < tableSize) {
            ArrayList<DS4_Entry<K, V>> bucket = yo.get(index);

            for (int i = 0; i < bucket.size(); i++) {
                DS4_Entry<K, V> entry = bucket.get(i);
                if (entry != null && entry.key.equals(key)) {
                    V oldValue = entry.value;
                    bucket.set(i, null); // tombstone
                    tombstones++;
                    itemCount--;
                    return oldValue;
                }
            }
            if (bucket.size() < bucketCapacity)
                return null;
            index = (index + 1) % tableSize;
            checkedBuckets++;
        }

        return null;
    }
    private void rebuild() {
        ArrayList<DS4_Entry<K, V>> allEntries = new ArrayList<>();
        for (ArrayList<DS4_Entry<K, V>> bucket : yo) {
            for (DS4_Entry<K, V> entry : bucket) {
                if (entry != null) {
                    allEntries.add(entry);
                }
            }
        }
        tableSize *= 2;
        loadFactor *= 2;
        tombstones = 0;
        itemCount = 0;
        yo.clear();
        for (int i = 0; i < tableSize; i++) {
            yo.add(new ArrayList<>());
        }
        for (DS4_Entry<K, V> e : allEntries) {
            insert(e.key, e.value);
        }
    }
    public Iterator<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        for (ArrayList<DS4_Entry<K, V>> bucket : yo) {
            for (DS4_Entry<K, V> entry : bucket) {
                if (entry != null)
                    keys.add(entry.key);
            }
        }
        return keys.iterator();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < yo.size(); i++) {
            sb.append("Bucket ").append(i).append(": ").append(yo.get(i)).append("\n");
        }
        return sb.toString();
    }
}