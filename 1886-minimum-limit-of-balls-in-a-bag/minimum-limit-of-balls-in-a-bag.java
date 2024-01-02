class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Set the search space for binary search
        int left = 1, right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int operationsNeeded = 0;

            // Count number of operations needed to make bags <= mid
            for (int num : nums) {
                operationsNeeded += (num - 1) / mid;

                // Optimization: Exit early if operationsNeeded > maxOperations
                if (operationsNeeded > maxOperations) {
                    break;
                }
            }

            // Update the search space
            if (operationsNeeded <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}