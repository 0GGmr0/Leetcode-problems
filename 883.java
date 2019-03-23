class Solution {
    public int projectionArea(int[][] grid) {
        int yz = 0;
        int xz = 0;
        int xy = 0;
        
        for(int i=0; i<grid.length; i++) {
            int maxYz = 0;
            int maxXz = 0;
            for(int j=0; j<grid[i].length; j++) {
                maxYz = Math.max(maxYz, grid[i][j]);
                maxXz = Math.max(maxXz, grid[j][i]);
                if(grid[i][j] != 0) xy++;
            }
            yz += maxYz;
            xz += maxXz;
        }
        
        return xy + yz + xz;
    }
}