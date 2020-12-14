//Runtime 3ms, Memory 39.1 MB

class Solution {
    public List<Integer> partitionLabels(String S) {

        List<Integer> partitions = new ArrayList<Integer>();

        int currentIndex = 0;
        while(currentIndex < S.length()) {
           char current = S.charAt(currentIndex); 
            int endIndex = S.lastIndexOf(current);
            S = S.replace(S.charAt(currentIndex), '-');

            for(int i = currentIndex + 1; i < endIndex; i++) {
                if(S.charAt(i) == '-') {
                    continue;
                }
                int lastIndex = S.lastIndexOf(S.charAt(i));
                if(lastIndex > endIndex) {
                    endIndex = lastIndex;
                }
                S = S.replace(S.charAt(i), '-');
            }        
            partitions.add(endIndex - currentIndex + 1);
            currentIndex = endIndex + 1;
        }
        return partitions;
    }
}