public class DS4_Doubly_Circular_LinkedList<E> implements DS4_Doubly_Circular_LinkedList_Interface<E> {
    private DS4_Doubly_Circular_LinkedList_Node<E> first;
    private DS4_Doubly_Circular_LinkedList_Node<E> last;
    private int size;

    public DS4_Doubly_Circular_LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public DS4_Doubly_Circular_LinkedList(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> node = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        first = node;
        last = node;
        first.setNext(first);
        first.setPrev(first);
        size = 1;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode() {
        return first;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        if(first==null){
            return null;
        } else{
            return first.getData();
        }
    }

    @Override
    public E getLast() {
        if(last==null){
            return null;
        } else{
            return last.getData();
        }
    }

    @Override
    public E removeFirst(){
        if (first==null){
            return null;
        }
        E data = first.getData();
        if (size==1) {
            first = null;
            last = null;
        } else{
            first = first.getNext();
            first.setPrev(last);
            last.setNext(first);
        }
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        if (last==null){
            return null;
        }
        E data = last.getData();
        if (size==1) {
            first = null;
            last = null;
        } else {
            last = last.getPrev();
            last.setNext(first);
            first.setPrev(last);
        }
        size--;
        return data;
    }

    @Override
    public void addFirst(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> yo = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (size == 0) {
            first = last = yo;
            yo.setNext(yo);
            yo.setPrev(yo);
        } else {
            yo.setNext(first);
            yo.setPrev(last);
            last.setNext(yo);
            first.setPrev(yo);
            first = yo;
        }
        size++;
    }

    @Override
    public void addLast(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> yo = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (size == 0) {
            first = yo;
            last = yo;
            yo.setNext(yo);
            yo.setPrev(yo);
        } else {
            yo.setPrev(last);
            yo.setNext(first);
            last.setNext(yo);
            first.setPrev(yo);
            last = yo;
        }
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int x) {
        if (x<0 || x>=size){
            return null;
        }
        DS4_Doubly_Circular_LinkedList_Node<E> herro = first;
        for (int i = 0; i<x; i++){
            herro = herro.getNext();
        }
        return herro.getData();
    }

    @Override
    public void add(int x, E data){
        if (x<=0) {
            addFirst(data);
        } else if (x>=size) {
            addLast(data);
        } else {
            DS4_Doubly_Circular_LinkedList_Node<E> yo = new DS4_Doubly_Circular_LinkedList_Node<>(data);
            DS4_Doubly_Circular_LinkedList_Node<E> herro = first;
            for (int i = 0; i<x; i++){
                herro = herro.getNext();
            }
            DS4_Doubly_Circular_LinkedList_Node<E> prev = herro.getPrev();
            prev.setNext(yo);
            yo.setPrev(prev);
            yo.setNext(herro);
            herro.setPrev(yo);
            size++;
        }
    }

    @Override
    public E remove(int x) {
        if (x<0 || x>= size) {
            return null;
        }
        if (x == 0) return removeFirst();
        if (x == size - 1) return removeLast();
        DS4_Doubly_Circular_LinkedList_Node<E> yo = first;
        for (int i = 0; i < x; i++){
            yo = yo.getNext();
        }
        E data = yo.getData();
        yo.getPrev().setNext(yo.getNext());
        yo.getNext().setPrev(yo.getPrev());
        size--;
        return data;
    }

    @Override
    public E set(int x, E data) {
        if (x < 0 || x >= size) return null;
        DS4_Doubly_Circular_LinkedList_Node<E> yo = first;
        for (int i = 0; i<x; i++){
            yo = yo.getNext();
        }
        E old = yo.getData();
        yo.setData(data);
        return old;
    }

    @Override
    public boolean isEmpty(){
        if(size==0){
            return true;
        } else{
            return false;
        }
    }

    @Override
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

    @Override
    public String backwardsToString() {
        String s = "[";
        if(size==0){
            s+="]";
            return s;
        }
        for(int i = size-1; i>=0; i++){
            if(i!=0){
                s+=get(i) + ", ";
            } else{
                s+=get(i) + "]";
            }
        }
        return s;
    }
}
