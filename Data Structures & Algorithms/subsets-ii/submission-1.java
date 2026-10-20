class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        subset(nums, 0, ans, new ArrayList<>());
        ans.add(new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void subset (int[] nums, int index, Set<List<Integer>> ans, List<Integer> cur){
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            //ans.add(new ArrayList<>(cur));

            cur.add(nums[i]);
            ArrayList<Integer> copy = new ArrayList<>(cur);
            Collections.sort(copy);
            ans.add(new ArrayList<>(copy));
            subset(nums, i + 1, ans, cur);
            cur.remove(cur.size() -1);
            subset(nums, i + 1, ans, cur);

        }
    }
}
