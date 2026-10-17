class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combo(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void combo(int[] candidates, int target, int index,
                List<Integer> cur, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // Include current number
        cur.add(candidates[index]);
        combo(candidates, target - candidates[index],
            index + 1, cur, ans);
        cur.remove(cur.size() - 1);

        // Exclude current number and all identical values
        int next = index + 1;
        while (next < candidates.length &&
            candidates[next] == candidates[index]) {
            next++;
        }

        combo(candidates, target, next, cur, ans);
    }
}
