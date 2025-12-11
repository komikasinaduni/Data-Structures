import java.util.ArrayList;

public class DS6_MinHeap<E extends Comparable<E>> implements DS6_HeapInterface<E> {

    private ArrayList<E> heap;

    public DS6_MinHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(E item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public E remove() {
        if (heap.isEmpty()) return null;
        E root = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return root;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    private void heapifyUp(int index) {
        while (index>0) {
            int parent = (index-1)/2;
            if (heap.get(index).compareTo(heap.get(parent))<0) {
                swap(index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int left = (index * 2)+1;
            int right = (index * 2)+2;
            int smallest = index;
            if (left<size && heap.get(left).compareTo(heap.get(smallest))<0) {
                smallest = left;
            }
            if (right<size && heap.get(right).compareTo(heap.get(smallest))<0) {
                smallest = right;
            }
            if (smallest==index) return;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int a, int b) {
        E temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    public E get(int x) {
        return heap.get(x);
    }
}
