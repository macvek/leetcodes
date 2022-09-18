public class QuickSort {
    public void quickSort(int[] values) {
        quickSortPart(values, 0, values.length -1);
    }

    public void quickSortPart(int[] values, int begin, int end) {
        int splitIdx = partition(values, begin, end);
        if (splitIdx == -1) {
            return;
        }

        quickSortPart(values, begin, splitIdx);
        quickSortPart(values, splitIdx+1, end);
    }

    public int partition(int[] values, int begin, int end) {
        if (end == begin) {
            return -1;
        }

        int pivotValue = values[(end + begin) / 2];

        int left = begin;
        int right = end;

        for (;;) {
            for (; left < right && values[left] < pivotValue; ++left);
            for (; left < right && values[right] >= pivotValue; --right);

            if (left < right) {
                swap(values, left, right);
                ++left;
                --right;
            }
            else {
                break;
            }
        }

        return right;
    }

    private void swap(int[] from, int a, int b) {
        int t = from[b];
        from[b] = from[a];
        from[a] = t;
    }
}
