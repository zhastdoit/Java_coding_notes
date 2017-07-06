/*LeetCodeQ53.Maximum_Subarray - classic!!
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/
//dp solution - classic!!
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int dp[] = new int[nums.length];
        if(nums.length==1) return nums[0];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = dp[i-1]+ nums[i] > nums[i] ? dp[i-1]+ nums[i] : nums[i] ;
            max = Math.max(dp[i],max);
        }
        return max;
    }
}