//Runtime 0ms, Memory 36.8 MB

enum Dir {
    EAST, WEST, NORTH, SOUTH;
}
class Solution {   
    public boolean isRobotBounded(String instructions) {
        int x = 0; //east/west
        int y = 0; //north/south
        Dir dir = Dir.NORTH;
        
        for(int i = 0; i < instructions.length(); i++) {
            if(instructions.charAt(i) == 'G') {
                switch(dir) {
                    case NORTH: y++; break;
                    case SOUTH: y--; break;
                    case EAST: x++; break;
                    case WEST: x--; break;
                }
            }
            else {
                if((dir == Dir.NORTH && instructions.charAt(i) == 'L') || (dir == Dir.SOUTH && instructions.charAt(i) == 'R')) {
                    dir = Dir.WEST;
                }
                else if((dir == Dir.SOUTH && instructions.charAt(i) == 'L') || (dir == Dir.NORTH && instructions.charAt(i) == 'R')) {
                   dir = Dir.EAST; 
                }
                else if((dir == Dir.EAST && instructions.charAt(i) == 'L') || (dir == Dir.WEST && instructions.charAt(i) == 'R')) {
                    dir = Dir.NORTH;
                }
                else  {
                   dir = Dir.SOUTH; 
                }
            }
        }
        
        if(dir != Dir.NORTH || (dir == Dir.NORTH && x == 0 && y == 0)) {
            return true;
        }
        return false;
    }
}