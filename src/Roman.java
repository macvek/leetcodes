import java.util.ArrayList;

public class Roman {
    public String intToRoman(int num) {
        int thousands = num / 1000;
        int hundreds = ( num % 1000 ) / 100;
        int tens = (num % 100) / 10;
        int units = (num % 10);

        String str1000 = times("M", thousands);
        String str100 = romanize(hundreds, "M", "D", "C");
        String str10 = romanize(tens, "C", "L", "X");
        String str1 = romanize(units, "X", "V", "I");

        return str1000 + str100 + str10 + str1;
    }

    private String romanize(int num, String top, String mid, String unit) {
        if (num == 9) {
            return unit+top;
        }
        else if (num >= 5) {
            return mid + times(unit, num-5);
        }
        else if (num == 4) {
            return unit + mid;
        }
        else {
            return times(unit, num);
        }
    }

    private String times(String what, int n) {
        String ret = "";
        for (int i=0;i<n;i++) {
            ret += what;
        }

        return ret;
    }



    public int romanToInt(String s) {
        ArrayList<RomanPair> pairs = new ArrayList<>();

        pairs.add(new RomanPair(1000, "M"));
        pairs.add(new RomanPair(900, "CM"));
        pairs.add(new RomanPair(500, "D"));
        pairs.add(new RomanPair(400, "CD"));
        pairs.add(new RomanPair(100, "C"));
        pairs.add(new RomanPair(90, "XC"));
        pairs.add(new RomanPair(50, "L"));
        pairs.add(new RomanPair(40, "XL"));
        pairs.add(new RomanPair(10, "X"));
        pairs.add(new RomanPair(9, "IX"));
        pairs.add(new RomanPair(5, "V"));
        pairs.add(new RomanPair(4, "IV"));
        pairs.add(new RomanPair(1, "I"));

        int ptr = 0;
        int sum = 0;

        while(ptr < s.length()) {
            boolean found = false;
            for (var each : pairs) {
                if (s.indexOf(each.marker, ptr) == ptr) {
                    sum += each.value;
                    ptr += each.marker.length();
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return sum;
    }

    static class RomanPair {
        int value;
        String marker;

        public RomanPair(int value, String marker) {
            this.value = value;
            this.marker = marker;
        }
    }
}
