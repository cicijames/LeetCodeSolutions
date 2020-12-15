//Runtime 1ms, Memory 45.7 MB

class Solution {
    public void reverseString(char[] s) {
        if(s.length < 2) {
            return;
        }
        
        for(int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = tmp;
        }
    }
}