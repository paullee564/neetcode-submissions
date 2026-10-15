class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        subset(nums, 0, ans, cur);
        return ans;
    }

    public void subset(int[] nums, int index,
                       List<List<Integer>> ans, List<Integer> cur) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // Exclude current number
        subset(nums, index + 1, ans, cur);

        // Include current number
        cur.add(nums[index]);
        subset(nums, index + 1, ans, cur);

        // Backtrack
        cur.remove(cur.size() - 1);
    }
}