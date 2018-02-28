/*
* https://leetcode.com/problems/permutations/description/
*/


class Solution {
    // Method 1: Recursion Tree ***Time Complexity: O(n!)  N factorial ***
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        helper(result, new LinkedList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> cur, int[] nums, boolean[] visited) {
        // No need to write this here: List<Integer> cur = new ArrayList<>(prev); -> use same list is fine.
        if(cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            System.out.println(cur);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            cur.add(nums[i]);   //Move to next layer
            visited[i] = true;
            helper(result, cur, nums, visited);
            cur.remove(cur.size()-1);  //Remember to change it back. (Visually move back to prev layer)
            visited[i] = false;
        }
        return;
    }
}
