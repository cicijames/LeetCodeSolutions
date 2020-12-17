//Runtime 2ms, Memory 43.9 MB

class Solution {
    public int findLonelyPixel(char[][] picture) {
        if(picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        if(picture.length == 1 && picture[0].length == 1) {
            return picture[0][0] == 'B' ? 1 : 0;
        }
    
        int[] colBs = new int[picture[0].length];
        Arrays.fill(colBs, 0);
        List<Integer> lonelyRows = new ArrayList<Integer>();
        
        for(int i = 0; i < picture.length; i++) {
            int rowB = -1;
            int rowCount = 0;
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] == 'B') {
                    rowCount++;
                    colBs[j]++;
                    if(rowB == -1) {
                        rowB = j;
                    }
                }
            }
            if(rowCount == 1) {
                lonelyRows.add(rowB);
            }
        }
        int count = 0;
        for(Integer col : lonelyRows) {
            if(colBs[col] == 1) {
                count++;
            }
        }    
        return count;
    }
}