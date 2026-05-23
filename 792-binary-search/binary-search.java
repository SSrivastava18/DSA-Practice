class Solution {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int s, int e) {

        if (s > e) {
            return -1;
        }

        int mid = s + (e - s) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target < nums[mid]) {
            return binarySearch(nums, target, s, mid - 1);
        }

        return binarySearch(nums, target, mid + 1, e);
    }
}