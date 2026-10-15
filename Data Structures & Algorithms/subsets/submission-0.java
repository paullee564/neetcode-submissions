class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        subset(nums, 0, ans, cur);
        return new ArrayList<>(ans);
    }

    public void subset(int[] nums, int index, Set<List<Integer>> ans, List<Integer> cur){
        if(index > nums.length -1){
            return;
        }
        ans.add(cur);
        ArrayList<Integer> copy = new ArrayList<>(cur);

        subset(nums, index + 1, ans, new ArrayList<>(copy));
        if(!copy.contains(nums[index])){
            copy.add(nums[index]);
            ans.add(new ArrayList<>(copy));
            subset(nums, index + 1, ans, new ArrayList<>(copy));
        }
        

    }
}
