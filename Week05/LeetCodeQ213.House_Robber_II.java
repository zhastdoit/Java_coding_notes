/*LeetCodeQ213.House_Robber_II
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length-1)),
                        helper(Arrays.copyOfRange(nums, 1, nums.length)));              
       	//divide into 2 situations and calculate separately, then choose the better one.
    }
    
    public int helper(int[] nums){ //Copy from 198. House Robber I
        int[] dp = new int[nums.length];
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        else{
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);//not =nums[1];
            for(int i=2; i<nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);          
            }
            return dp[nums.length-1];
        }
    }
}