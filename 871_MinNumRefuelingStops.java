//Runtime 1ms, Memory 39.2 MB

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        if(target <= startFuel) {
            return 0;
        }
        if(stations.length == 0 || stations[0].length == 0 || stations[0][0] > startFuel) {
            return -1;
        }
        
        int nextStop = howFarCanWeGet(target, startFuel, stations);
        int numStops = 1;
        
        while(nextStop != Integer.MAX_VALUE && nextStop != -1) {
            startFuel += stations[nextStop][1];
            stations[nextStop][1] = 0;
            nextStop = howFarCanWeGet(target, startFuel, stations);
            numStops++;
        }
        return nextStop == -1 ? -1 : numStops;
    }
    
    public static int howFarCanWeGet(int target, int currentFuel, int[][] stations) {
        int farthestDist = currentFuel;
        int bestStation = -1;
        int currentStation = 0;
        
        while(currentStation < stations.length && currentFuel >= stations[currentStation][0]) {
            if(farthestDist < currentFuel + stations[currentStation][1]) {
                farthestDist = currentFuel + stations[currentStation][1];
                bestStation = currentStation;
            }
            if(farthestDist >= target) {
                return Integer.MAX_VALUE;
            }
            currentStation++;
        }
        return bestStation;
    }
}