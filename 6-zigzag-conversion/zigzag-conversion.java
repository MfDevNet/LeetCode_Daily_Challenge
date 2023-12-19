public class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int index = 0;
        int step = 1;
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0) {
                step = 1;
            } else if (index == numRows - 1) {
                step = -1;
            }
            index += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);  // Output: "PAHNAPLSIIGYIR"

        numRows = 4;
        result = convert(s, numRows);
        System.out.println(result);  // Output: "PINALSIGYAHRPI"

        s = "A";
        numRows = 1;
        result = convert(s, numRows);
        System.out.println(result);  // Output: "A"
    }
}