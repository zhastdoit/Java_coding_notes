/*
Given a collection of distinct numbers, return all possible permutations.
For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

//DFS Solution
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        getResult(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }
    public void getResult(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] isVisited){
        if(path.size()==nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(isVisited[i]){
                continue;
            }
            path.add(nums[i]);
            isVisited[i]=true;
            getResult(res, path, nums, isVisited);
            path.remove(path.size()-1);
            isVisited[i]=false;
        }
    }
}