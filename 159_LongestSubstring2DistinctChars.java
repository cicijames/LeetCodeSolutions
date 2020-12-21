//Runtime 4ms, Memory 37.3 MB

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) {
            return s.length();
        }
        char one = s.charAt(0);
        char two = one;
        int longest = 0;
        char lastChar = one;
        int countLastChar = 1;
        int currentLength = 1;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != one && two == one) {
                two = s.charAt(i);
            }
            if(s.charAt(i) == two || s.charAt(i) == one) {
                currentLength++;
                if(lastChar == s.charAt(i)) {
                    countLastChar++;
                }
                else {
                    lastChar = s.charAt(i);
                    countLastChar = 1;
                }
            }
            else {
                longest = Math.max(longest, currentLength);
                currentLength = countLastChar + 1;
                one = lastChar;
                two = s.charAt(i);
                lastChar = two;
                countLastChar = 1;
            }
        }
        return Math.max(longest, currentLength);
    }
}