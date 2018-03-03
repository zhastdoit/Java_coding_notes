/*
https://leetcode.com/problems/minimum-height-trees/description/
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < n; i++) {
            result.add(i);
        }  
        List<Integer>[] appearance = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            appearance[i] = new ArrayList<>();
        }  
        for(int[] edge : edges) {
            appearance[edge[0]].add(edge[1]);
            appearance[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>(); 
        for(int i = 0; i < n; i++) {
            if(appearance[i].size() == 1) {
                leaves.add(i);
            }
        }
        while(result.size() > 2) {
            int leaves_size = leaves.size();
            for(int i = 0; i < leaves_size; i++) {
                int leaf = leaves.get(0);
                for(int next : appearance[leaf]) {
                    appearance[next].remove(new Integer(leaf));
                    if(appearance[next].size() == 1) { //Core: add it to leaves only when it is the real leaf 
                        if(!leaves.contains(next)) {
                            leaves.add(next);
                        }
                    }
                }
                leaves.remove(0);
                result.remove(leaf);
            } 
        }
        return result.stream().collect(Collectors.toList());
    }
}
