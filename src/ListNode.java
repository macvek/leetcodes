public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int... list) {
        val = list[0];
        if (list.length > 1) {
            int[] tails = new int[list.length-1];
            System.arraycopy(list, 1, tails, 0, list.length-1);
            next = new ListNode(tails);
        }
    }

    @Override
    public String toString() {
        return val+(next != null ? ","+next : "");
    }

}