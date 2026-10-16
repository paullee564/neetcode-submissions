class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        combo(nums, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    public void combo(int[] nums, int target, int start, List<List<Integer>> ans, List<Integer> cur){
        if(target < 0){return;}
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            combo(nums, target - nums[i], i, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
