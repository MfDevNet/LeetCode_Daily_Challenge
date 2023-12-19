public class Solution {
    public static boolean isPalindrome(int x) {
        // Special cases: negative numbers and numbers ending with 0 (except 0 itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        // For even-digit numbers, x will be equal to reversed
        // For odd-digit numbers, x will be half of reversed (e.g., 12321 -> x = 12, reversed = 123)
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        int x = 121;
        boolean result = isPalindrome(x);
        System.out.println(result);  // Output: true

        x = -121;
        result = isPalindrome(x);
        System.out.println(result);  // Output: false

        x = 10;
        result = isPalindrome(x);
        System.out.println(result);  // Output: false
    }
}