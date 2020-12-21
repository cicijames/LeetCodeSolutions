//Runtime 14 ms, Memory 39.7 MB

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length < 2) {
            return position.length;
        }
        
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        
        int fleets = position.length;
        int carToCatch = 0;
        int currentCar = 1;
        while(currentCar < cars.length) {
            if((double) (target - cars[currentCar][0]) / cars[currentCar][1] <= (double) (target - cars[carToCatch][0]) / cars[carToCatch][1]) {
                fleets--;
            }
            else {
                carToCatch = currentCar;
            }
            currentCar++;
        }      
        return fleets;
    }
}