//Runtime 0ms, Memory 36.6 MB

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleRows = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return triangleRows;
        }
        triangleRows.add(new ArrayList<Integer>(List.of(1)));
        if(numRows == 1) {
            return triangleRows;
        }
        numRows--;
        while(numRows > 0) {
            triangleRows.add(generateNextRow(triangleRows.get(triangleRows.size() - 1)));
            numRows--;
        }
        return triangleRows;
    }
    
    public static List<Integer> generateNextRow(List<Integer> previousRow) {
        List<Integer> nextRow = new ArrayList<Integer>();
        int lastElement = 0;
        for(int i = 0; i < previousRow.size(); i++) {
            nextRow.add(previousRow.get(i) + lastElement);
            lastElement = previousRow.get(i);         
        }
        nextRow.add(1);
        return nextRow;
    }
}