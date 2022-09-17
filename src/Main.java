public class Main {
    public static void main(String[] args) {

        {
            ListNode t = new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(5,2,6,3,9,1,7,3,8,4));
            System.out.println(t);

            ListNode u = new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(5,2,6,3,9,1,7,3,4,1,5,2));
            System.out.println(u);

            ListNode w = new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(5));
            System.out.println(w);

            ListNode x = new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(5,2));
            System.out.println(x);

            ListNode y = new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(5,2,4));
            System.out.println(y);

        }

        if (false)
        {
            ListNode first = new ListNode(1,2,3,4,5,6,7,8);
            ListNode last = null;
            ListNode t = new ReverseEvenLengthGroups().rotate(first, last);
            System.out.println(t);
        }


        if (false)
        {
            NestedInteger i = new NestedInteger(new Object[] { new Object[0] });

            NestedIterator iterator = new NestedIterator(i.getList());
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println("EOF");
        }

        if (false)
        {
            NestedInteger i = new NestedInteger(new Object[] { 10,11,12,13,14,15, new Object[] {
                    22,23,24,25, new Object[] { new Object[] { 41,42,new Object[] {51,52 }}}
            , 28 }});

            NestedIterator iterator = new NestedIterator(i.getList());
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }

            System.out.println("EOF");
        }

        if (false)
        {
            System.out.println(new MyHeap(new int[] { 1 }));
            System.out.println(new MyHeap(new int[] { 1,2 }));
            System.out.println(new MyHeap(new int[] { 1,2,-1 }));
            System.out.println(new MyHeap(new int[] { 1,31,1 }));
            int[] src = {1, 3, 2, 5, 4, 6, 71, 82, 13, 25, 56, 67, 78, 19, 111, -21};
            MyHeap x = new MyHeap(src);
            System.out.println(x);
            MyHeap empty = new MyHeap();
            for (int i=0; i<src.length;i++) {
                empty.add(src[src.length-1-i]);
            }
            System.out.println(empty);

            x.dumpValue(111);
            empty.dumpValue(111);
            for (int i=0;i<src.length;i++) {
                System.out.println("seek for: "+src[i]+" at "+x.findValue(src[i]));
            }

            x.delete(0);
            System.out.println(x);

            x.delete(4);
            System.out.println(x);

            x.add(100000000);
            x.add(-100);
            x.dumpValue(-100);
            x.add(12);
            System.out.println("12 at "+x.findValue(12));
            System.out.println(x);

            x.dumpValue(100000000);
            x.dumpValue(82);
            x.dumpValue(78);
        }

        if (false)
        {
            MyHeap heap = new MyHeap(new int[] { 1,5,1,6,12,64124,612,18,-123,291,-12315,1,0,123});

        }

        if (false)
        {
            TreeNode a = TreeNodeMaker.makeNode(new Integer[] {2,3,1,3,1,null,1});
            it(2, new PseudoPalindromicPaths().pseudoPalindromicPaths(a));

            TreeNode b = TreeNodeMaker.makeNode(new Integer[] {2,1,1,1,3,null,null,null,null,null,1});
            it(1, new PseudoPalindromicPaths().pseudoPalindromicPaths(b));

            TreeNode c = TreeNodeMaker.makeNode(new Integer[] {9});
            it(1, new PseudoPalindromicPaths().pseudoPalindromicPaths(c));

            Integer[] intTab1= IntArrayFromFile.load("C:\\Users\\macve\\Desktop\\Prototyping\\IntTab1.txt");
            TreeNode d = TreeNodeMaker.makeNode(intTab1);
            long l = System.currentTimeMillis();
            new PseudoPalindromicPaths().pseudoPalindromicPaths(d);
            System.out.println(System.currentTimeMillis() - l);
        }

        if (false)
        {
            TreeNode root = TreeNodeMaker.makeNode(new Integer[] {2,1,1,1,3,null,null,null,null,null,1});
            it(2, root.val);
            it(1, root.left.val);
            it(1, root.right.val);
            it(1, root.left.left.val);
            it(3, root.left.right.val);
            it(1, root.left.right.right.val);

        }
        if (false)
        {
            TreeNode root = TreeNodeMaker.makeNode(new Integer[]{2, 3, 1, 3, 1, null, 1});
            it(2, root.val);
            it(3, root.left.val);
            it(3, root.left.left.val);
            it(1, root.right.val);
            it(1, root.left.right.val);
        }
        if (false)
        {
            var t = new FractionAddAndSub();
            it("0/1", t.fractionAddition("-1/2+1/2"));
            it("1/3", t.fractionAddition("-1/2+1/2+1/3"));
            it("-1/6", t.fractionAddition("1/3-1/2"));
            it("2/1", t.fractionAddition("5/3+1/3"));
            it("41/12", t.fractionAddition("7/2+2/3-3/4"));
        }

        if (false){
            var t = new TicTacToe();
            it (true, t.validTicTacToe(new String[] {"   ", "   ", "   "}));
            it (true, t.validTicTacToe(new String[] {"   ", " X ", "   "}));
            it (true, t.validTicTacToe(new String[] {"   ", " X ", " O "}));
            it (true, t.validTicTacToe(new String[] {" X ", " X ", " O "}));
            it (false, t.validTicTacToe(new String[] {" O ", " X ", " O "}));
            it (true, t.validTicTacToe(new String[] {"XXX", "XOO", "XOO"}));
            it (false, t.validTicTacToe(new String[] {"OOO", "XXX", "   "}));
            it (true, t.validTicTacToe(new String[] {"OOO", "X X", " X "}));
            it (true, t.validTicTacToe(new String[] {"XXX","OOX","OOX"}));
            it (false, t.validTicTacToe(new String[] {"XXX","XOO","OO "}));

        }

        if (false) {
            var t = new IntegerToEnglishWord();
            it("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One", t.numberToWords(1234567891));
            it("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", t.numberToWords(1234567));
            it("Twelve Thousand Three Hundred Forty Five", t.numberToWords(12345));
            it("One Hundred Twenty Three", t.numberToWords(123));


            it("One Hundred", t.numberToWords(100));
            it("Nine Hundred", t.numberToWords(900));
            it("Nine Hundred Ninety Nine", t.numberToWords(999));
            it("Twenty One", t.numberToWords(21));
            it("Ninety Nine", t.numberToWords(99));


            it("Zero", t.numberToWords(0));
            it("One", t.numberToWords(1));
            it("Two", t.numberToWords(2));
            it("Three", t.numberToWords(3));
            it("Four", t.numberToWords(4));
            it("Five", t.numberToWords(5));
            it("Six", t.numberToWords(6));
            it("Seven", t.numberToWords(7));
            it("Eight", t.numberToWords(8));
            it("Nine", t.numberToWords(9));
            it("Ten", t.numberToWords(10));
            it("Eleven", t.numberToWords(11));
            it("Twelve", t.numberToWords(12));
            it("Thirteen", t.numberToWords(13));
            it("Fourteen", t.numberToWords(14));
            it("Fifteen", t.numberToWords(15));
            it("Sixteen", t.numberToWords(16));
            it("Seventeen", t.numberToWords(17));
            it("Eighteen", t.numberToWords(18));
            it("Nineteen", t.numberToWords(19));
            it("Twenty", t.numberToWords(20));
        }


        if (false) {
            var r = new Roman();
            it("III", r.intToRoman(3));
            it("LVIII", r.intToRoman(58));
            it("MCMXCIV", r.intToRoman(1994));

            it(1, r.romanToInt("I"));
            it(2, r.romanToInt("II"));
            it(3, r.romanToInt("III"));
            it(4, r.romanToInt("IV"));
            it(58, r.romanToInt("LVIII"));
            it(1994, r.romanToInt("MCMXCIV"));
        }

    }

    private static void it(boolean a, boolean b) {
        if (a == b) {
            System.out.println("OK....");
        }
        else {
            System.out.println("WRONG. "+a+" != "+b);
        }
    }

    private static void it(String a, String b) {
        if (a.equals(b)) {
            System.out.println("OK....");
        }
        else {
            System.out.println("WRONG. "+a+" != "+b);
        }
    }

    private static void it(double a, double b) {
        if (a == b) {
            System.out.println("OK....");
        }
        else {
            System.out.println("WRONG. "+a+" != "+b);
        }
    }

    private static void it(int a, int b) {
        if (a == b) {
            System.out.println("OK....");
        }
        else {
            System.out.println("WRONG. "+a+" != "+b);
        }
    }
}
