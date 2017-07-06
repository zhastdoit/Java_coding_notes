/*LeetCode279.Perfect_Squares !Essential
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

//DP solution: Use the value that used before
public class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            int minNumber = Integer.MAX_VALUE;
            int j = 1;
            while(i-j*j>=0){
                minNumber = Math.min(minNumber, dp[i-j*j]+1);
                j++;
            }
            dp[i]=minNumber;
        }
        return dp[n];
    }
}