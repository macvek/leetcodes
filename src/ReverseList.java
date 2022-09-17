public class ReverseList {
    public static void main(String[] x) {
        ListNode longList = new ListNode(10,99,22,33,44);
        System.out.println(longList);

        /*
        tail_reverse(L) -> tail_reverse(L,[]).

        tail_reverse([],Acc) -> Acc;
        tail_reverse([H|T],Acc) -> tail_reverse(T, [H|Acc]).
         */

        ListNode reversed = tail_reverse(longList, null);
        System.out.println(reversed);

    }

    public static ListNode tail_reverse(ListNode list, ListNode acc) {
        if (list == null) {
            return acc;
        }
        else {
            ListNode H = list;
            ListNode T = list.next;

            ListNode newList = H;
            newList.next = acc;
            return tail_reverse(T, newList);
        }
    }
}
