
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
    public DS4_LinkedList_Node getLastNode() {
        DS4_LinkedList_Node<E> yo = data2.getNext();
        boolean x =true;
        while(data2!=null) {
            yo = data2.getNext();
            if (yo== null) {
                break;
            } else {
                data2 = data2.getNext();
            }
        }
        return yo;
    }

    @Override
    public E getFirst() {
        return data2.getData();
    }

    @Override
    public E getLast() {
        DS4_LinkedList_Node<E> yo = data2.getNext();
        boolean x =true;
        while(data2!=null) {
            yo = data2.getNext();
            if (yo== null) {
                break;
            } else {
                data2 = data2.getNext();
            }
        }
        return yo.getData();
    }

    @Override
    public E removeFirst() {

    }

    @Override
    public E removeLast() {
        DS4_LinkedList_Node<E> yo = data2.getNext();
        boolean x =true;
        while(data2!=null) {
            yo = data2.getNext();
            if (yo== null) {
                break;
            } else {
                data2 = data2.getNext();
            }
        }
        data2.setData(null);
        return yo.getData();
    }

    @Override
    public void addFirst(E data) {

    }

    @Override
    public void addLast(E data) {

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
