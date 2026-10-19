class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutations(nums, ans, new ArrayList<>(), new int[nums.length]);
        return ans;
    }

    public void permutations(int[] nums, List<List<Integer>> ans,
                             List<Integer> cur, int[] added) {

        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (added[i] == 1) {
                continue;
            }

            // Choose
            cur.add(nums[i]);
            added[i] = 1;

            // Explore
            permutations(nums, ans, cur, added);

            // Undo
            cur.remove(cur.size() - 1);
            added[i] = 0;
        }
    }
}