import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DS3_Set<E> implements SetInterface<E> {
    private ArrayList<E> data;
    public DS3_Set(){
        data=new ArrayList<>();
    }
    @Override
    public boolean add(E o) {
        if(data.contains(o)){
            return false;
        }
        return data.add(o);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public boolean contains(E o) {
        return data.contains(o);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public boolean remove(E o) {
        return data.remove(o);
    }

    @Override
    public int size() {
        return data.size();
    }
    public String toString(){
        return data.toString();
    }

}
