
public class DS4_LinkedList <E> implements DS4_LinkedList_Interface<E> {
    private DS4_LinkedList_Node<E> data2;
    public DS4_LinkedList(){
        data2 = null;
    }

    public DS4_LinkedList(E data){
        data2.setData(data);
        data2.setNext(data2);
    }

    @Override
    public DS4_LinkedList_Node getFirstNode() {
        return data2;
    }

    @Override
    public DS4_LinkedList_Node<E> getLastNode() {
        if (data2 == null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = data2;
        while (yo.getNext() != null) {
            yo = yo.getNext();
        }
        return yo;
    }


    @Override
    public E getFirst() {
        return data2.getData();
    }

    @Override
    public E getLast() {
        if (data2==null) {
            return null;
        }
        DS4_LinkedList_Node<E> yo = data2;
        while (yo.getNext()!= null) {
            yo = yo.getNext();
        }
        return yo.getData();
    }

    @Override
    public E removeFirst() {
        boolean x =true;
        E yo = data2.getData();
        data2.setNext(data2.getNext());
        return yo;

    }

    @Override
    public E removeLast() {
        if (data2 == null) {
            return null;
        }
        if (data2.getNext() == null) {
            E data = data2.getData();
            data2 = null;
            return data;
        }
        DS4_LinkedList_Node<E> yo = data2;
        DS4_LinkedList_Node<E> hello = null;
        while (yo.getNext() != null) {
            hello = yo;
            yo = yo.getNext();
        }
        hello.setNext(null);
        return yo.getData();
    }

    @Override
    public void addFirst(E data) {
        DS4_LinkedList_Node<E> yo = data2;
        data2.setData(data);
        data2.setNext(yo);
    }

    @Override
    public void addLast(E data) {
        DS4_LinkedList_Node<E> yo = data2;
        data2.setData(data);
        data2.setNext(yo);
    }

    public void clear() {

    }

    public int size() {

    }

    @Override
    public E get(int x) {

    }

    @Override
    public void add(int x, E data) {

    }

    @Override
    public E remove(int x) {

    }

    @Override
    public E set(int x, E data) {

    }

    @Override
    public boolean isEmpty() {

    }
}
