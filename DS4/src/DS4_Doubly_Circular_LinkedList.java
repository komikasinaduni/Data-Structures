public class DS4_Doubly_Circular_LinkedList<E> implements DS4_Doubly_Circular_LinkedList_Interface<E> {
    private DS4_Doubly_Circular_LinkedList_Node<E> head;
    private DS4_Doubly_Circular_LinkedList_Node<E> tail;
    private int size;

    public DS4_Doubly_Circular_LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DS4_Doubly_Circular_LinkedList(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> node = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        head = node;
        tail = node;
        head.setNext(head);
        head.setPrev(head);
        size = 1;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getFirstNode() {
        return head;
    }

    @Override
    public DS4_Doubly_Circular_LinkedList_Node<E> getLastNode() {
        return tail;
    }

    @Override
    public E getFirst() {
        if(head==null){
            return null;
        } else{
            return head.getData();
        }
    }

    @Override
    public E getLast() {
        if(tail==null){
            return null;
        } else{
            return tail.getData();
        }
    }

    @Override
    public E removeFirst(){
        if (head==null){
            return null;
        }
        E data = head.getData();
        if (size==1) {
            head = null;
            tail = null;
        } else{
            head = head.getNext();
            head.setPrev(tail);
            tail.setNext(head);
        }
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        if (tail==null){
            return null;
        }
        E data = tail.getData();
        if (size==1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
        }
        size--;
        return data;
    }

    @Override
    public void addFirst(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> yo = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (size == 0) {
            head = tail = yo;
            yo.setNext(yo);
            yo.setPrev(yo);
        } else {
            yo.setNext(head);
            yo.setPrev(tail);
            tail.setNext(yo);
            head.setPrev(yo);
            head = yo;
        }
        size++;
    }

    @Override
    public void addLast(E data) {
        DS4_Doubly_Circular_LinkedList_Node<E> yo = new DS4_Doubly_Circular_LinkedList_Node<>(data);
        if (size == 0) {
            head = yo;
            tail = yo;
            yo.setNext(yo);
            yo.setPrev(yo);
        } else {
            yo.setPrev(tail);
            yo.setNext(head);
            tail.setNext(yo);
            head.setPrev(yo);
            tail = yo;
        }
        size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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
        DS4_Doubly_Circular_LinkedList_Node<E> herro = head;
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
            DS4_Doubly_Circular_LinkedList_Node<E> herro = head;
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
        DS4_Doubly_Circular_LinkedList_Node<E> yo = head;
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
        DS4_Doubly_Circular_LinkedList_Node<E> yo = head;
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
