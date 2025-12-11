<<<<<<< HEAD
public class DS6_MaxHeap<E extends Comparable> implements DS6_HeapInterface<E extends Comparable> {
    @Override
    public void insert(E item) {

=======
import java.util.ArrayList;
public class DS6_MaxHeap<E extends Comparable<E>> implements DS6_HeapInterface<E> {
    private ArrayList<E> heap;
    public DS6_MaxHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void insert(E item) {
        heap.add(item);
        heapifyUp(heap.size()-1);
>>>>>>> b78f41dd1dfc30485e242b3688a8cac69e4363a2
    }

    @Override
    public E remove() {
<<<<<<< HEAD
        return null;
=======
        if (heap.isEmpty()){
            return null;
        }
        E root = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        if (!heap.isEmpty()) {
            heapifyDown(0);
        }
        return root;
>>>>>>> b78f41dd1dfc30485e242b3688a8cac69e4363a2
    }

    @Override
    public boolean isEmpty() {
<<<<<<< HEAD
        return false;
=======
        return heap.isEmpty();
>>>>>>> b78f41dd1dfc30485e242b3688a8cac69e4363a2
    }

    @Override
    public int size() {
<<<<<<< HEAD
        return 0;
=======
        return heap.size();
>>>>>>> b78f41dd1dfc30485e242b3688a8cac69e4363a2
    }

    @Override
    public void clear() {
<<<<<<< HEAD

=======
        heap.clear();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    private void heapifyUp(int index) {
        while (index>0) {
            int p = (index-1)/2;
            if (heap.get(index).compareTo(heap.get(p))>0) {
                swap(index, p);
                index = p;
            } else {
                return;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while(true) {
            int l = (index*2)+1;
            int r = (index*2)+2;
            int largest = index;
            if (l<size && heap.get(l).compareTo(heap.get(largest))>0) {
                largest = l;
            }
            if (r<size && heap.get(r).compareTo(heap.get(largest))>0) {
                largest = r;
            }
            if (largest==index) {
                return;
            }
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int a, int b) {
        E temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
>>>>>>> b78f41dd1dfc30485e242b3688a8cac69e4363a2
    }
}