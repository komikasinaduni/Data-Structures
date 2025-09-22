import java.util.ArrayList;

public class MyQueue<E> implements QueueInterface<E>{
    private ArrayList<E> yo;
    public MyQueue(){
        yo = new ArrayList<>();
    }

    @Override
    public void offer(E o) {
        yo.add(o);
    }

    @Override
    public E element() {
        if(isEmpty()){
            return null;
        } else{
            return yo.get(0);
        }
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        } else{
            return yo.remove(0);
        }
    }

    @Override
    public int size() {
        return yo.size();
    }

    @Override
    public boolean isEmpty() {
        return yo.isEmpty();
    }

    @Override
    public void clear() {
        yo.clear();
    }

    @Override
    public String toString(){
        return yo.toString();
    }
}
