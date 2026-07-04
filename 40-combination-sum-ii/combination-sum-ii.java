class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    void solve(int idx, int[] candidates, int target,
               List<List<Integer>> ans,
               List<Integer> curr) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if (i > idx && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;

            curr.add(candidates[i]);


            solve(i + 1, candidates, target - candidates[i], ans, curr);

            curr.remove(curr.size() - 1);
        }
    }
}