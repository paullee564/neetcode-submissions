class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
        int[] nums = digits.chars().map(Character::getNumericValue).toArray();
        ArrayList<String> ans = new ArrayList<>();
        combo(nums, ans, "", 0, map);
        return ans;
    }

    public void combo(int[] nums, List<String> ans, String cur, int index, HashMap<Integer, char[]> map){
        if(index == nums.length){
            ans.add(cur);
            return;
        }

        for(char c: map.get(nums[index])){
            combo(nums, ans, cur + c, index + 1, map);
            // if(cur.length() >= 1){
            //     cur = cur.substring(0, cur.length() - 1);
            // }
        }
        
    }
}
