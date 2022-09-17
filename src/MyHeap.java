import java.util.Arrays;
import java.util.stream.Collectors;

public class MyHeap {

    private Integer[] store;
    private int minHeapHit;

    public MyHeap(int[] values) {
        store = new Integer[values.length];
        for (int i=0;i<values.length;i++) {
            //put(values[i]);
            store[i] = values[i];
        }

        heapify();
    }

    @Override
    public String toString() {
        return "HITS:"+minHeapHit+"\t"+Arrays.asList(store).stream().map(x -> null == x ? "null" : x.toString()).collect(Collectors.joining(","));
    }

    void delete(int idx) {
        minHeapHit = 0;
        if (idx == store.length-1) {
            shrink();
        }
        else {
            store[idx] = store[store.length - 1];
            shrink();
            minHeap(idx/2);
        }


    }

    private void shrink() {
        Integer[] shrunk = new Integer[store.length-1];
        System.arraycopy(store, 0, shrunk, 0, store.length-1);
        store = shrunk;
    }

    void heapify() {
        minHeapHit = 0;
        for (int i= (store.length-1 )/2; i >= 0;i--) {
            minHeap(i);
        }
    }

    void minHeap(int idx) {
        ++minHeapHit;
        int nIdx = idx;
        int leftIdx = 2*idx+1;
        int rightIdx = 2*idx+2;

        if (leftIdx < store.length && store[leftIdx] < store[nIdx]) {
            nIdx = leftIdx;
        }

        if (rightIdx < store.length && store[rightIdx] < store[nIdx]) {
            nIdx = rightIdx;
        }

        if (nIdx != idx) {
            int tmp = store[nIdx];
            store[nIdx] = store[idx];
            store[idx] = tmp;

            minHeap(nIdx);
        }
    }

}
