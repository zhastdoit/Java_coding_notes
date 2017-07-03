/*LeetCodeQ64.Minimum_Path_Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/
// Answer that need more space (It don't extra space as every value is accessed only once)
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int x = 0; x<grid.length; x++){
            for (int y = 0; y<grid[0].length; y++){
                if(x==0){
                    if(y==0) dp[x][y] = grid[0][0];
                    else dp[x][y]=dp[x][y-1]+grid[x][y];
                }
                else if (y==0){
                    dp[x][y]= dp[x-1][y]+grid[x][y];
                }
                else if(x!=0&&y!=0){
                    dp[x][y] = Math.min(dp[x][y-1],dp[x-1][y])+grid[x][y];
                } 
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
