/*LeetCodeQ518.Coin_Change_2
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
*/

public class Solution {
    public int change(int amount, int[] coins) {
       	int[] dp = new int[amount+1];
       	dp[0]=1;
        for(int coin : coins){
           for(int i=coin;i<=amount;i++){
               dp[i]+=dp[i-coin]; //Cannot use dp[i]=dp[i-coin]+1 It's not +1 but +dp[i-coin]
           }
        }
        return dp[amount];
    }
}