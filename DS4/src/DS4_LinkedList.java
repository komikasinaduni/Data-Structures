
public class DS4_LinkedList <E> implements DS4_LinkedList_Interface<E> {
    private DS4_LinkedList_Node<E> first;
    private DS4_LinkedList_Node<E> last;
    private int size;
    public DS4_LinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    public DS4_LinkedList(E data){
        first = new DS4_LinkedList_Node<>(data);
        last = first;
        size = 1;
    }

    @Override
    public DS4_LinkedList_Node getFirstNode() {
        return first;
    }

    @Override
    public DS4_LinkedList_Node<E> getLastNode() {
        if (first == null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = first;
        while (yo.getNext() != null) {
            yo = yo.getNext();
        }
        return yo;
    }


    @Override
    public E getFirst() {
        return first.getData();
    }

    @Override
    public E getLast() {
        if (first==null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = first;
        while (yo.getNext()!= null) {
            yo = yo.getNext();
        }
        return yo.getData();
    }

    @Override
    public E removeFirst() {
        boolean x =true;
        E yo = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        size--;
        return yo;

    }

    @Override
    public E removeLast() {
        if (first==null) {
            return null;
        }
        if (first.getNext()==null) {
            E data = first.getData();
            first = null;
            last = null;
            size = 0;
            return data;
        }
        DS4_LinkedList_Node<E> yo = first;
        DS4_LinkedList_Node<E> hello = null;
        while (yo.getNext()!=null) {
            hello = yo;
            yo = yo.getNext();
        }
        hello.setNext(null);
        last = hello;
        size--;
        return yo.getData();
    }

    public void addFirst(E data) {
        DS4_LinkedList_Node<E> yo = new DS4_LinkedList_Node<>(data);
        if (first==null) {
            first = yo;
            last = yo;
        } else {
            yo.setNext(first);
            first = yo;
        }
        size++;
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> yo = new DS4_LinkedList_Node<>(data);
        if (last == null) {
            first = yo;
            last = yo;
        } else {
            last.setNext(yo);
            last = yo;
        }
        size++;
    }

    public void clear() {
        first = null;
        size=0;
    }

    public int size() {
        return size;
    }

    @Override
    public E get(int x) {
        DS4_LinkedList_Node<E> yo = first;
        for (int i = 0; i<x; i++) {
            yo = yo.getNext();
        }
        return yo.getData();
    }

    @Override
    public void add(int x, E data) {
        DS4_LinkedList_Node<E> hello = new DS4_LinkedList_Node<>(data);
        if (x == 0) {
            hello.setNext(first);
            first = hello;
        } else {
            DS4_LinkedList_Node<E> yo = first;
            for (int i = 0; i<x-1; i++) {
                yo = yo.getNext();
            }
            hello.setNext(yo.getNext());
            yo.setNext(hello);
        }
        size++;
    }

    @Override
    public E remove(int x) {
        E lol;
        if (x==0) {
            lol = first.getData();
            first = first.getNext();
        } else {
            DS4_LinkedList_Node<E> yo = first;
            for (int i = 0; i<x-1; i++) {
                yo = yo.getNext();
            }
            lol = yo.getNext().getData();
            yo.setNext(yo.getNext().getNext());
        }
        size--;
        return lol;
    }

    @Override
    public E set(int x, E data) {
        DS4_LinkedList_Node<E> yo = first;
        for (int i = 0; i<x; i++) {
            yo = yo.getNext();
        }
        E hello = yo.getData();
        yo.setData(data);
        return hello;
    }

    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    public String toString(){
        String s = "[";
        if(size==0){
            s+="]";
            return s;
        }
        for(int i = 0; i<size; i++){
            if(i!=size-1){
                s+=get(i) + ", ";
            } else{
                s+=get(i) + "]";
            }
        }
        return s;
    }
}
