
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
        E last = data2.get(data2.size()-1).getData();
        data2.remove(data2.size()-1).getData();
        return last;
    }

    @Override
    public void addFirst(E data) {
        data2.add(0, new DS4_LinkedList_Node<>(data));
    }

    @Override
    public void addLast(E data) {
        data2.add(data2.size()-1, new DS4_LinkedList_Node<>(data));

    }

    public void clear() {
        data2.clear();
    }

    public int size() {
        return data2.size();
    }

    @Override
    public E get(int x) {
        return data2.get(x).getData();
    }

    @Override
    public void add(int x, E data) {
        data2.add(x, new DS4_LinkedList_Node<>(data));
    }

    @Override
    public E remove(int x) {
        E remove = data2.get(x).getData();
        data2.remove(x);
        return remove;
    }

    @Override
    public E set(int x, E data) {
        E set = data2.get(x).getData();
        data2.set(x, new DS4_LinkedList_Node<>(data));
        return set;
    }

    @Override
    public boolean isEmpty() {
        return data2.isEmpty();
    }
}
