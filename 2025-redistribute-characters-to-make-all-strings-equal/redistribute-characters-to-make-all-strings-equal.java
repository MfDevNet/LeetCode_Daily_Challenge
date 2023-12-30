public class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        
        // Count the frequency of each character in all the words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }
        
        // Check if the frequency of each character is divisible by the length of the words array
        for (int i = 0; i < 26; i++) {
            if (count[i] % words.length != 0) {
                return false;
            }
        }
        
        return true;
    }
}