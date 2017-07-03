/*LeetCode265.Paint_House_II
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
Follow up:
Could you solve it in O(nk) runtime?
*/
//? Is my answer O(nk)?
//DP solution:
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length == 0 || costs[0].length == 0) return 0;
        int[][] dp = new int[costs.length][costs[0].length]; 
        for(int j=0; j<costs[0].length; j++){
            dp[0][j]=costs[0][j];
        }
        for(int i=1; i<costs.length; i++){
            for(int j=0; j<costs[0].length; j++){
            	//This house use the jth color, find the min value in last house from the color that is not jth color.
                dp[i][j] = costs[i][j] + findMinExcept(dp[i-1], j);
                //not dp[i-1][j]+findMinExcept(costs[i], j)
            }   
        }
        return findMinExcept(dp[costs.length-1],-1);
    }
    public int findMinExcept(int[] arr, int j){
        int min=Integer.MAX_VALUE; //Have to be max value first.
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                if(i!=j)
                    min=arr[i];
            }
        }
        return min;
    }
}
