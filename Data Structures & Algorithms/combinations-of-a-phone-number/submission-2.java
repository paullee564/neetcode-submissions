class Solution {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) {
            return ans;
        }

        StringBuilder cur = new StringBuilder();
        backtrack(digits, 0, cur, ans);

        return ans;
    }

    private void backtrack(String digits, int index,
                           StringBuilder cur, List<String> ans) {

        if (index == digits.length()) {
            ans.add(cur.toString());
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {
            cur.append(c);

            backtrack(digits, index + 1, cur, ans);

            cur.deleteCharAt(cur.length() - 1);
        }
    }
}