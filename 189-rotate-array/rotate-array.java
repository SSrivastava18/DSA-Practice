class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        // Reverse the entire array
        reverse(0, n - 1, nums);

        // Reverse first k elements
        reverse(0, k - 1, nums);

        // Reverse remaining elements
        reverse(k, n - 1, nums);
    }

    public void reverse(int i, int j, int[] nums) {
        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}