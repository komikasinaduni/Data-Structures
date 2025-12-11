public class DS6_PriorityQueue<E extends Comparable<E>> implements DS6_PriorityQueueInterface<E> {
    private DS6_MinHeap<E> heap;
    public DS6_PriorityQueue() {
        heap = new DS6_MinHeap<>();
    }

    @Override
    public void offer(E o) {
        heap.insert(o);
    }

    @Override
    public E poll() {
        return heap.remove();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty(){
        return heap.isEmpty();
    }

    @Override
    public void clear(){
        heap.clear();
    }

    @Override
    public E get(int x){
        return heap.get(x);
    }

    @Override
    public E element() {
        if (heap.isEmpty()){
            return null;
        }
        return heap.get(0);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}