//Runtime 57 ms, Memory 39.9 MB

//[13,18,23,25,32,48,60,62,91,97,205]

class Solution {
    public int connectSticks(int[] sticks) {
        Queue<Integer> stickQueue = new PriorityQueue<Integer>();
        for(int stick : sticks) {
            stickQueue.offer(stick);
        }
        
        int totalCost = 0;
        while(stickQueue.size() > 1) {
            int newStick = stickQueue.poll() + stickQueue.poll();
            totalCost += newStick;
            stickQueue.offer(newStick);
        }
        
        return totalCost;
    }
}