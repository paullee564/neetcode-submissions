class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        part(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    // the question is to pass a new string with the partition part removed? or have an index variable. no you need index to say which part you need to start at
    public void part(String s, List<List<String>> ans, List<String> cur, int start){
        if(start == s.length() && counter(cur) == s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start + 1; i <= s.length(); i++){
            String space = s.substring(start, i);
            if(isPalindrome(space)){
                cur.add(space);
                part(s, ans, cur, i);
                cur.remove(cur.size() -1);
            }
            else{
                part(s, ans, cur, i);
            }
        }


    }

    public int counter(List<String> str){
        int count = 0;
        for(String s: str){
            count += s.length();
        }
        return count;
    }

    public boolean isPalindrome(String str) {
        if (str == null) return false;
        // Convert to lowercase to make the check case-insensitive
        str = str.toLowerCase(); 
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters matched
    }
}
