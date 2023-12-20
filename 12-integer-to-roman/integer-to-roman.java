public class Solution {

    private static final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] romanNumeralsValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRoman(int num) {
        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < romanNumerals.length; i++) {
            while (num >= romanNumeralsValues[i]) {
                romanNumeral.append(romanNumerals[i]);
                num -= romanNumeralsValues[i];
            }
        }

        return romanNumeral.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}