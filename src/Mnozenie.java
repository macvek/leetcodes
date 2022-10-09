public class Mnozenie {
    public static void main(String[] args) {
        Mnozenie m = new Mnozenie();
        System.out.println(m.multiply("12346","45678"));
        System.out.println(m.multiply("123","456"));
        System.out.println(m.multiply("12","45"));
        System.out.println(m.multiply("4","3"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        int size = num1.length() + num2.length();
        char[] result = new char[size];
        for (int idx = 0; idx < size; idx++) {
            result[idx]='0';
        }

        for (int i = 0; i < num2.length(); i++) {
            char digit = num2.charAt(i);
            char[] multResult = mulByDigit(num1, digit);

            int tenMult = num2.length() - i - 1;

            sumLists(result, multResult, tenMult);
        }

        return asRevertedString(result);
    }

    public String asRevertedString(char[] input) {
        int leadingZeros = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            char c = input[i];
            if (c == '0') {
                ++leadingZeros;
            } else {
                break;
            }
        }

        int size = input.length - leadingZeros;
        if (size == 0) {
            return "0";
        }

        char[] result = new char[size];

        for (int i = 0; i < size; i++) {
            result[i] = input[input.length - 1 - i - leadingZeros];
        }

        return new String(result);
    }

    public void sumLists(char[] res, char[] toSum, int toSumOffset) {
        int offset = 0;
        int toSumLen = toSum[toSum.length-1] == 'x' ? toSum.length-1 : toSum.length;

        for (int i = 0; i < toSumLen; i++) {
            int toSumDigit = toSum[i] - '0';
            int resDigit = res[i + toSumOffset] - '0';

            int sum = toSumDigit + resDigit + offset;
            offset = sum / 10;
            char c = (char) ('0' + (sum % 10));
            res[i + toSumOffset] = c;

        }

        int i=toSumLen-1;
        while(offset > 0) {
            ++i;
            int val = offset + (res[i + toSumOffset]-'0');
            offset = val/10;
            char c = (char) ('0' + (val%10));
            res[i + toSumOffset] = c;
        }
    }

    public char[] mulByDigit(String source, char digit) {
        char[] result = new char[source.length() + 1];
        int digitVal = digit - '0';
        int offset = 0;
        for (int i = source.length()-1; i >= 0; i--) {
            int each = source.charAt(i) - '0';
            int calc = each * digitVal + offset;
            offset = calc / 10;
            char c = (char) ('0' + (calc % 10));
            result[source.length()-i-1] = c;
        }

        if (offset > 0) {
            char c = (char) ('0' + offset);
            result[source.length()] = c;
        }
        else {
            result[source.length()] = 'x';
        }

        return result;
    }
}
