class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    void solve(int idx, int[] candidates, int target,
               List<List<Integer>> ans,
               List<Integer> curr) {

        if (idx == candidates.length) {
            if (target == 0)
                ans.add(new ArrayList<>(curr));
            return;
        }

        solve(idx + 1, candidates, target, ans, curr);

        if (candidates[idx] <= target) {

            curr.add(candidates[idx]);

            solve(idx, candidates, target - candidates[idx], ans, curr);

            curr.remove(curr.size() - 1);
        }
    }
}