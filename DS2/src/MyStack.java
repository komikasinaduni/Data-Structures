import java.util.ArrayList;
import java.util.Stack;

public class MyStack<E> implements StackInterface<E>{
    private ArrayList<E> yo;

    public MyStack(){
        yo = new ArrayList<>();
    }


    public void push(E o) {
        yo.add(o);
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        } else{
            return yo.get(yo.size()-1);
        }
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        } else{
            return yo.remove(yo.size()-1);
        }
    }

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

}
