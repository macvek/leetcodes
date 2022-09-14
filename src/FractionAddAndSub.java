import java.util.ArrayList;
import java.util.List;

public class FractionAddAndSub {
    public String fractionAddition(String expression) {

        List<Pair> parts = parse(expression);
        Pair output = normalize(parts);
        return output.top+"/"+output.bottom;

    }

    public Pair normalize(List<Pair> parts) {
        int commonBottom = 1;
        for (Pair p : parts) {
            int eachBottom = Math.abs(p.bottom);
            int higher = eachBottom > commonBottom ? eachBottom : commonBottom;
            int lower = eachBottom > commonBottom ? commonBottom : eachBottom;

            if (higher % lower == 0) {
                commonBottom = higher;
            }
            else {
                commonBottom = higher * lower;
            }
        }

        int topSum = 0;
        for (Pair p : parts) {
            topSum += p.top * (commonBottom / p.bottom);
        }

        if (topSum == 0) {
            commonBottom = 1;
        }
        else {
            int divider = nwd(Math.abs(topSum), Math.abs(commonBottom));
            topSum = topSum/divider;
            commonBottom = commonBottom/divider;
        }

        if (commonBottom < 0) {
            topSum = -1 * topSum;
            commonBottom = -1 * commonBottom;
        }
        return new Pair(topSum, commonBottom);
    }

    public int nwd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return nwd(b, a % b);
        }
    }

    public List<Pair> parse(String expression) {
        ArrayList<Pair> pairs = new ArrayList<>();

        int ptr = 0;
        while(ptr < expression.length()) {
            String top = pickNext(expression, ptr); ptr += top.length();
            String slash = pickNext(expression, ptr); ptr += slash.length();
            String bottom = pickNext(expression, ptr); ptr += bottom.length();

            pairs.add(new Pair(Integer.valueOf(top), Integer.valueOf(bottom)));
        }

        return pairs;
    }

    public String pickNext(String expression, int ptr) {
        if (expression.charAt(ptr) == '/') {
            return "/";
        }

        boolean foundDigit = false;
        int i = ptr;
        for (;i<expression.length();i++) {
            char c = expression.charAt(i);
            boolean digit = c >= '0' && c <= '9';
            if (digit && !foundDigit) {
                foundDigit = true;
            }
            else if (!digit && foundDigit) {
                break;
            }
        }

        return expression.substring(ptr, i);
    }

    public static class Pair {
        public Pair(int top, int bottom) {
            this.top = top;
            this.bottom = bottom;
        }

        int top;
        int bottom;
    }
}
