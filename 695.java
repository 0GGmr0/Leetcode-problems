/**
 * @program: interview
 * @description:
 * @author: 0GGmr0
 * @create: 2019-03-23 11:38
 */
class Solution {

    static int cou = 0;
    static int[][] tag;
    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        tag = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length;j++) {
                if(tag[i][j] == 0 && grid[i][j] == 1) {
                    cou = 0;
                    dfs(i, j, grid);
                    max = cou > max ? cou : max;
                }
            }
        }
        return max;
    }


    static void dfs(int i, int j, int[][] grid) {
        if(tag[i][j] == 1 || grid[i][j] == 0) return;
        tag[i][j] = 1;
        cou++;
        if(i < grid.length - 1) dfs(i + 1, j, grid);
        if(i > 0) dfs(i - 1, j, grid);
        if(j > 0) dfs(i, j - 1, grid);
        if(j < grid[0].length - 1) dfs(i, j + 1, grid);
    }


    public static void main(String[] args) {
        int[][] a = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(a));
    }
}
