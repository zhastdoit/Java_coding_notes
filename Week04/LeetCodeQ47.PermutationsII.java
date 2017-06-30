/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/
//DEPTH FIRST
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            if(isVisited[i]||(i != 0 && nums[i] == nums[i-1] && isVisited[i-1])){
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