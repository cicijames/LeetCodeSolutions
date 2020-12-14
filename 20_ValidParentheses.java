//Runtime 1ms, Memory 37.2 MB

class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case ')': 
                    if(stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default: stack.push(s.charAt(i));
            }
        }      
        return stack.empty() ? true : false;
    }
}