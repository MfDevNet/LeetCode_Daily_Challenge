public class Solution {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Rearrange the array
        for (int i = 0; i < n; i++) {
            // While the current number is positive and within the array bounds
            // and it is not already at its correct position
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap the current number with the number at its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first index where the number does not match its position
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        int result = firstMissingPositive(nums);
        System.out.println(result);  // Output: 3

        nums = new int[]{3, 4, -1, 1};
        result = firstMissingPositive(nums);
        System.out.println(result);  // Output: 2

        nums = new int[]{7, 8, 9, 11, 12};
        result = firstMissingPositive(nums);
        System.out.println(result);  // Output: 1
    }
}