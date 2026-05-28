class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), used, ans);
        // helper(nums, new ArrayList<>(), ans);

        return ans;
        
    }
        // private void helper(int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        // if (curr.size() == nums.length) {
        //     ans.add(new ArrayList<>(curr));
        //     return;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     if (!curr.contains(nums[i])) {
                
        //         curr.add(nums[i]);

        //         helper(nums, curr, ans);

        //         curr.remove(curr.size() - 1);
                
        //     }
        // }
    private void helper(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> ans) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(nums[i]);

                helper(nums, curr, used, ans);

                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}

