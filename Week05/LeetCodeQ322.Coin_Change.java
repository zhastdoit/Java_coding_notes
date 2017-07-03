/*LeetCodeQ322.Coin_Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

//DP Solution 1
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length == 0) return -1;
        int[] count = new int[amount+1];
        Arrays.fill(count, Integer.MAX_VALUE);
		Arrays.sort(coins);
        count[0] = 0;
     	return helper(coins, amount, count);
    }
    
    public int helper(int[] coins, int remain, int[] count){
        if(count[remain] != Integer.MAX_VALUE){
            return count[remain];
        }
        int res = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++){
            if(remain >= coins[i]){
                int temp = helper(coins, remain-coins[i], count); 
                if(temp >= 0) {
                    res = Math.min(res, temp + 1);
                }
            }
        }
        // Above we find the least amount of coins we gonna use to solve the remaing words. If the above "if" is not happened -> res == Integer.MAX_VALUE. -> we cannot do it (-1). Good thing is that we only need to do once for each value (count), as long as we calculated once, we can reuse them in future
        count[remain] = (res == Integer.MAX_VALUE ? -1 : res);
        return count[remain];
    }
}

/*
The greedy method not always work. <= useless :( , but it provides a basic understanding
toward the topic -> we can think of greedy first, then find a good apporoach via dp.
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length == 0) return -1;
		Arrays.sort(coins);
     	return helper(coins,amount);
    }
    
    public int helper(int[] coins, int amountLeft){
        if (amountLeft == 0) return 0; 
        for(int i=coins.length-1;i>=0;i--){
            if (amountLeft>=coins[i]){ //need to be >=
                int left = helper(coins, amountLeft - coins[i]); 
                return left>=0 ? left+1 : -1;
            } 
        }
        return -1;
    }
}
*/