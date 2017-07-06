/*LeetCodeQ70.Climbing_Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
*/
//dp solution
public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        int[] dp = new int[n];
        if (n==1) return 1;
        if (n==2) return 2;
        dp[0]=1; //1
        dp[1]=2; //2: 2,11 / 3: 21.12.111 /4: 22 112 211 121 1111 
        for(int i=2;i<n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }