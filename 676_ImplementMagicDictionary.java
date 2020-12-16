//Runtime 23ms, Memory 39.6 MB

class MagicDictionary {

    Map<Integer, List<String>> dict;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashMap<Integer, List<String>>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String str : dictionary) {
            if(!dict.containsKey(str.length())) {
                dict.put(str.length(), new ArrayList<String>(List.of(str)));
            }
            else {
                dict.get(str.length()).add(str);
            }
        }
    }
    
    public boolean search(String searchWord) {      
        if(!dict.containsKey(searchWord.length())) {
            return false;
        }
        List<String> list = dict.get(searchWord.length());
        for(String word : list) {
            if(oneDiff(word, searchWord)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean oneDiff(String one, String two) {
        if(one.length() != two.length() || one.equals(two)) {
            return false;
        }
        for(int i = 0; i < one.length(); i++) {
            if(one.charAt(i) != two.charAt(i)) {
                if(one.substring(i + 1).equals(two.substring(i + 1))) {
                    return true;
                } 
                return false;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */