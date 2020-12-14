//Runtime 8ms, Memory 37.6 MB

class Solution {
    public List<Integer> partitionLabels(String S) {

        List<Integer> partitions = new ArrayList<Integer>();
        List<Character> checked = new ArrayList<Character>();

        int currentIndex = 0;
        while(currentIndex < S.length()) {
           char current = S.charAt(currentIndex); 
            int endIndex = S.lastIndexOf(current);
            checked.add(S.charAt(currentIndex));

            for(int i = currentIndex + 1; i < endIndex; i++) {
                if(checked.contains(S.charAt(i))) {
                    continue;
                }
                int lastIndex = S.lastIndexOf(S.charAt(i));
                if(lastIndex > endIndex) {
                    endIndex = lastIndex;
                }
            }        
            partitions.add(endIndex - currentIndex + 1);
            currentIndex = endIndex + 1;
        }
        return partitions;
    }
}