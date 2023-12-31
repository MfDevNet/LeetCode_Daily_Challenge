class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Create a HashSet to store the wordDict for efficient lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // Create a boolean array to store whether s from index i to the end can be
        // segmented or not
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: an empty string can be segmented
        dp[0] = true;

        // Iterate through s from left to right
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible substrings starting from index i-1 to 0
            for (int j = i - 1; j >= 0; j--) {
                // Break the string into two parts: s1 and s2
                // If s1 can be segmented and s2 is in the wordDict, then s can be segmented
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // The last element of dp array represents whether s can be segmented or not
        return dp[s.length()];
    }
}