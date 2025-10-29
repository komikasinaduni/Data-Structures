
public class DS4_LinkedList <E> implements DS4_LinkedList_Interface<E> {
    private DS4_LinkedList_Node<E> head;
    private DS4_LinkedList_Node<E> tail;
    private int size;
    public DS4_LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public DS4_LinkedList(E data){
        this.head = new DS4_LinkedList_Node<>(data);
    }

    @Override
    public DS4_LinkedList_Node getFirstNode() {
        return head;
    }

    @Override
    public DS4_LinkedList_Node<E> getLastNode() {
        if (head == null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = head;
        while (yo.getNext() != null) {
            yo = yo.getNext();
        }
        return yo;
    }


    @Override
    public E getFirst() {
        return head.getData();
    }

    @Override
    public E getLast() {
        if (head==null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = head;
        while (yo.getNext()!= null) {
            yo = yo.getNext();
        }
        return yo.getData();
    }

    @Override
    public E removeFirst() {
        boolean x =true;
        E yo = head.getData();
        head.setNext(head.getNext());
        return yo;

    }

    @Override
    public E removeLast() {
        if (head==null) {
            return null;
        }
        if (head.getNext()==null) {
            E data = head.getData();
            head = null;
            return data;
        }
        DS4_LinkedList_Node<E> yo = head;
        DS4_LinkedList_Node<E> hello = null;
        while (yo.getNext()!=null) {
            hello = yo;
            yo = yo.getNext();
        }
        hello.setNext(null);
        return yo.getData();
    }

    public void addFirst(E data) {
        DS4_LinkedList_Node<E> yo = new DS4_LinkedList_Node<>(data);
        if (head==null) {
            head = yo;
            tail = yo;
        } else {
            yo.setNext(head);
            head = yo;
        }
        size++;
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> yo = new DS4_LinkedList_Node<>(data);
        if (tail == null) {
            head = yo;
            tail = yo;
        } else {
            tail.setNext(yo);
            tail = yo;
        }
        size++;
    }

    public void clear() {
        head = null;
        size=0;
    }

    public int size() {
        return size;
    }

    @Override
    public E get(int x) {
        DS4_LinkedList_Node<E> yo = head;
        for (int i = 0; i<x; i++) {
            yo = yo.getNext();
        }
        return yo.getData();
    }

    @Override
    public void add(int x, E data) {
        DS4_LinkedList_Node<E> hello = new DS4_LinkedList_Node<>(data);
        if (x == 0) {
            hello.setNext(head);
            head = hello;
        } else {
            DS4_LinkedList_Node<E> yo = head;
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
            lol = head.getData();
            head = head.getNext();
        } else {
            DS4_LinkedList_Node<E> yo = head;
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
        DS4_LinkedList_Node<E> yo = head;
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
