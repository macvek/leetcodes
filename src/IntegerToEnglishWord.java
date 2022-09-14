import java.util.ArrayList;
import java.util.stream.Collectors;

public class IntegerToEnglishWord {

    private static final String[] toTwenty = new String[] {"Zero",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
    };

    private static final String[] toHundred = new String[] {
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety",
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return toTwenty[0];
        }
        ArrayList<String> parts = new ArrayList<>();

        if (num >= 1_000_000_000) {
            int millions = num / 1_000_000_000;
            if (millions > 0) {
                fillPartsOfHundreds(parts, millions);
                parts.add("Billion");
            }
        }

        if (num >= 1_000_000) {
            int millions = (num % 1_000_000_000) / 1_000_000;
            if (millions > 0) {
                fillPartsOfHundreds(parts, millions);
                parts.add("Million");
            }
        }

        if (num >= 1_000) {
            int thousands = (num % 1_000_000) / 1_000;
            if (thousands > 0) {
                fillPartsOfHundreds(parts, thousands);
                parts.add("Thousand");
            }
        }

        fillPartsOfHundreds(parts, num % 1000);

        return parts.stream().collect(Collectors.joining(" "));

    }

    public void fillPartsOfHundreds(ArrayList<String> parts, int num) {
        int hundreds = num / 100;

        if (hundreds > 0) {
            parts.add(toTwenty[hundreds]);
            parts.add("Hundred");
        }

        int dec = num % 100;
        if (dec > 0) {
            if (dec < 20) {
                parts.add(toTwenty[dec]);
            } else {
                int tenPart = dec / 10;
                if (tenPart != 0) {
                    parts.add(toHundred[tenPart - 2]);
                }

                int unitPart = dec % 10;
                if (unitPart != 0) {
                    parts.add(toTwenty[unitPart]);
                }
            }
        }
    }

}
