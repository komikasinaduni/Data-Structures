import java.util.ArrayList;

import java.util.Iterator;

public class DS3_Map <E, S> implements MapInterface<E, S>{
    private ArrayList<E> data;
    public DS3_Map(){
        data=new ArrayList<>();
    }

    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public DS3_Set<E> keySet() {
        return null;
    }

    @Override
    public ArrayList values() {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }
}
