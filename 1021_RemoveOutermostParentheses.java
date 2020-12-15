//Runtime 3ms, Memory 39 MB

class Solution {
    public String removeOuterParentheses(String S) {
        
        if(S.length() < 3) {
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int openCount = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == ')') {
                openCount--;
                if(openCount == 0) {
                    builder.append(S.substring(index + 1, i));
                    index = i + 1;
                }
            }
            else if(S.charAt(i) == '(') {
                openCount++;
            }
        }

        return builder.toString();
    }
}