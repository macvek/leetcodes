public class Main {
    public static void main(String[] args) {
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

    private static void it(int a, int b) {
        if (a == b) {
            System.out.println("OK....");
        }
        else {
            System.out.println("WRONG. "+a+" != "+b);
        }
    }
}
