public class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int expectedSize = 1;
        int movedSize;
        ListNode ptr = head;
        ListNode pointerOnGroupHead = head;

        while (ptr != null) {
            ListNode groupHead = ptr;
            ListNode lastInGroup = null;
            movedSize = 0;
            for (; movedSize < expectedSize && ptr != null; movedSize++) {
                lastInGroup = ptr;
                ptr = ptr.next;
            }

            if (movedSize > 0 && movedSize % 2 == 0) {
                rotate(groupHead, lastInGroup);

                pointerOnGroupHead.next = lastInGroup;
                groupHead.next = ptr;

                pointerOnGroupHead = groupHead;

            } else {
                pointerOnGroupHead = lastInGroup;
            }

            ++expectedSize;
        }

        return head;
    }


    public ListNode rotate(ListNode first, ListNode until) {
        int length = 0;
        ListNode ptr = first;
        for (; ; ) {
            ++length;
            if (ptr.next == until) {
                if (until != null) {
                    ++length;
                }
                break;
            }
            else {
                ptr = ptr.next;
            }
        }

        ListNode[] list = new ListNode[length];
        ptr = first;
        for (int i = 0; i < length; i++) {
            list[i] = ptr;
            ptr = ptr.next;
        }

        for (int i = length - 1; i > 0; i--) {
            list[i].next = list[i - 1];
        }

        list[0].next = null;
        return list[length - 1];

    }
}
