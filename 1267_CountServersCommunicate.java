//Runtime 2ms, Memory 46.1 MB

class Solution {
    public int countServers(int[][] grid) {
        int[] colServers = new int[grid[0].length];
        Arrays.fill(colServers, 0);
        int count = 0;
        List<Integer> lonelyRow = new ArrayList<Integer>();
        
        for(int i = 0; i < grid.length; i++) {
            int rowCount = 0;
            int serverCol = -1;
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rowCount++;
                    colServers[j] += 1;
                    if(serverCol == -1) {
                        serverCol = j;
                    }
                }
            }
            if(rowCount == 1) {
                lonelyRow.add(serverCol);
            }
            else {
                count += rowCount;
            }
        }
        for(Integer col : lonelyRow) {
            if(colServers[col] > 1) {
                count++;
            }
        }
        return count;
    }
}