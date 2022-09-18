public class QuickSort {
    public void quickSort(int[] v) {
        quickSort(v, 0, v.length-1);
    }

    public void quickSort(int[] v, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivotIdx = (start + end) / 2;
        int pivot = v[pivotIdx];

        swap(v, end, pivotIdx);

        int repl = start;
        for (;v[repl] < pivot;repl++);

        for (int seeker = repl+1;seeker<end;seeker++) {
            if (v[seeker] < pivot) {
                swap(v, seeker, repl);
                ++repl;
            }
        }

        swap(v, repl, end);

        quickSort(v, start, repl - 1);
        quickSort(v, repl+1, end);
    }

    private void swap(int[] from, int a, int b) {
        int t = from[b];
        from[b] = from[a];
        from[a] = t;
    }
}
