//Runtime 28 ms, Memory 40.2 MB

class Solution {
    
    Set<Integer> changed;
    int size;
    int cols;
    Random rand;

    public Solution(int n_rows, int n_cols) {
        changed = new HashSet<Integer>();
        size = n_rows * n_cols;
        cols = n_cols;
        rand = new Random();
    }
    
    public int[] flip() {
        int cellId = rand.nextInt(size);
        while(changed.contains(cellId)) {
            cellId = (cellId + 1) % size;
        }
        changed.add(cellId);
        return new int[] {cellId / cols, cellId % cols};       
    }
    
    public void reset() {
        changed.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */