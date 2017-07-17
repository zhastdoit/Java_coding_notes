/*LeetCodeQ292.Nim_Game
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/

public class Solution {
    public boolean canWinNim(int n) {
        if(n>Integer.MAX_VALUE) return false;
        if(n<=3) return true;
        boolean[] dp = new boolean[4];
        dp[0]=false;    
        dp[1]=true;
        dp[2]=true;
        dp[3]=true;
        for (int i=4; i <= n; i++){
            dp[i%4] = !(dp[(i-3)%4] && dp[(i-2)%4] && dp[(i-1)%4]);
        }
        return dp[n%4];  //Error: Test Case: 1348820612  ->Time Limit Exceeded 
    }
}