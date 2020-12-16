//Runtime 6ms, Memory 48.6 MB

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        boolean startFound = false;
        boolean endFound = false;
        for(int i = 0; i < intervals.length; i++) {
            if(!startFound && intervals[i][1] >= toBeRemoved[0]) {
                startFound = true;
                if(intervals[i][0] < toBeRemoved[0]) {
                    list.add(new ArrayList<Integer>(List.of(intervals[i][0], toBeRemoved[0])));   
                }
            }
            else if(!startFound || (startFound && endFound)) {
                list.add(new ArrayList<Integer>(List.of(intervals[i][0], intervals[i][1])));
            }
            if(startFound && intervals[i][1] >= toBeRemoved[1] && !endFound) {
                endFound = true;  
                if(toBeRemoved[1] < intervals[i][1]) {
                    list.add(new ArrayList<Integer>(List.of(Math.max(toBeRemoved[1], intervals[i][0]), intervals[i][1])));
                }
            }
        }
        return list;
    }
}