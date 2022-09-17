import java.util.Arrays;
import java.util.stream.Collectors;

public class MyHeap {

    private Integer[] store;

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
        return Arrays.asList(store).stream().map(x -> null == x ? "null" : x.toString()).collect(Collectors.joining(","));
    }

    void heapify() {
        for (int i= (store.length-1 )/2; i--> 0;) {
            minHeap(i);
        }
    }

    void minHeap(int idx) {
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

    public void put(int v) {
        int idx = placeFor(v);
        if (store[idx] != null) {
            //...
        }
        else {
            store[idx] = v;
        }
    }

    private int placeFor(int v) {
        int i=0;
        for(;;) {
            Integer lookup = store[i];
            if (lookup == null) {
                return i;
            }
            else if (v <= lookup) {
                i = 2*i+1;
            }
            else {
                i = 2*i+2;
            }

            if( i>= store.length ) {
                extendStore(i+1);
            }
        }
    }

    private void extendStore(int newSize) {
        Integer[] nextStore = new Integer[newSize];
        System.arraycopy(store, 0, nextStore, 0, store.length);
        store = nextStore;
    }
}
