/*
    DP: O(n^2) solution
*/
class Solution {
    public boolean canCross(int[] stones) {
        //DP solution. 
        if(stones == null || stones.length == 0) {
            return true;
        }
        if(stones[1] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>(); //island, last step length
        for(int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        Set<Integer> firstStep = map.get(1);
        firstStep.add(1);
        for(int stone : stones) {  // O(n)
            if(stone == 0) {
                continue;
            }
            for(int step : map.get(stone)) {  //This for loop and the inner for loop: O(k steps * n stones) ~ O(n)
                for(int i = step - 1; i <= step + 1; i++) {
                    if(i <= 0) {
                        continue;
                    }
                    if(map.containsKey(stone + i)) {
                        map.get(stone + i).add(i);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}
