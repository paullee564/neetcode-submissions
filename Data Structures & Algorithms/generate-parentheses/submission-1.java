class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, n, ans, "");
        return ans;
        
    }

    public void generate(int open, int close, int n, List<String> ans, String cur){
        if(cur.length() == n * 2){
            ans.add(cur);
            return;
        }

        if(open < n){
            generate(open + 1, close, n, ans, cur + "(");
        }
        if(close < open){
            generate(open, close + 1, n , ans, cur + ")");
        }
    }
}
