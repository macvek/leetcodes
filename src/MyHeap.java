import java.util.Arrays;
import java.util.stream.Collectors;

public class MyHeap {

    private Integer[] store;
    private int minHeapHit;

    public MyHeap() {
        store = new Integer[0];
    }

    public MyHeap(int[] values) {
        store = new Integer[values.length];
        for (int i=0;i<values.length;i++) {
            store[i] = values[i];
        }

        heapify();
    }

    @Override
    public String toString() {
        return "HITS:"+minHeapHit+"\t"+Arrays.asList(store).stream().map(x -> null == x ? "null" : x.toString()).collect(Collectors.joining(","));
    }


    Integer findValue(int value) {
        return findValue(value, 0);
    }

    void dumpValue(int value) {
        Integer idx = findValue(value, 0);
        System.out.println("VALUE:"+value+" at IDX:"+idx);
        int parent = idx;
        while(parent > 0) {
            parent = (parent-1)/2;
            System.out.println("PARENT IDX:"+parent+" PARENT VALUE:"+store[parent]);
        }
    }

    Integer findValue(int needle, int ptr) {
        while(ptr < store.length) {
            Integer lookup = store[ptr];
            if (needle == lookup) {
                return ptr;
            }
            if (needle > lookup) {
                Integer ret = findValue(needle, ptr*2 + 1);
                if (ret != null) {
                    return ret;
                }
                return findValue(needle, ptr*2 + 2);
            }
            else {
                return null;
            }
        }

        return null;
    }

    void delete(int idx) {
        minHeapHit = 0;
        if (idx == store.length-1) {
            shrink();
        }
        else {
            store[idx] = store[store.length - 1];
            shrink();
            minHeap(idx);
            pullUp(idx);
        }
    }

    private void pullUp(int idx) {
        while(idx > 0) {
            int parent = (idx -1)/2 ;
            if (store[parent] > store[idx]) {
                ++minHeapHit;
                swap(parent, idx);
                idx = parent;
            }
            else {
                return;
            }
        }
    }

    void swap(int a, int b) {
        int tmp = store[a];
        store[a] = store[b];
        store[b] = tmp;
    }

    void add(int value) {
        minHeapHit = 0;
        extend();
        store[store.length-1] = value;
        pullUp(store.length-1);

    }

    private void extend() {
        changeSize(1);
    }

    private void shrink() {
        changeSize(-1);
    }

    private void changeSize(int offset) {
        int copySize = Math.min(store.length, store.length+offset);
        Integer[] changed = new Integer[store.length+offset];
        System.arraycopy(store, 0, changed, 0, copySize);
        store = changed;
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
            swap(nIdx, idx);
            minHeap(nIdx);
        }
    }

}
