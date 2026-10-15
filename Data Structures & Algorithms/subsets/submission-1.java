class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();

        subset(nums, 0, ans, cur);
        return new ArrayList<>(ans);
    }

    public void subset(int[] nums, int index,
                       Set<List<Integer>> ans,
                       List<Integer> cur) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // Exclude current number
        subset(nums, index + 1, ans, new ArrayList<>(cur));

        // Include current number
        List<Integer> copy = new ArrayList<>(cur);
        copy.add(nums[index]);

        subset(nums, index + 1, ans, copy);
    }
}