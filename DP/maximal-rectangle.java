/*
* https://leetcode.com/problems/maximal-rectangle/description/
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int w = matrix[0].length;
        int[] height = new int[w];
        //Arrays.fill(height, 0);       Default
        int[] from_left = new int[w];
        //Arrays.fill(from_left, 0);    Default
        int[] from_right = new int[w];
        Arrays.fill(from_right, w);     //w-1);  left can reach w-1, when left == w-1,  right - left should be 1 so right need to be at w.
        int ans = 0; 
        for(char[] row : matrix) {
            int leftmost = 0;
            int rightmost = w; //w-1;
            for(int i = 0; i < w; i++) {
                height[i] = row[i] == '0' ? 0 : height[i] + 1;
            }
            
            for(int i = 0; i < w; i++) {
                if(row[i] != '0') {
                    from_left[i] = Math.max(leftmost, from_left[i]);  
                } else {
                    from_left[i] = 0;
                    leftmost = i + 1; //next one as the left edge of the rectangle.
                }
            }
            
            for(int i = w - 1; i >= 0; i--) {
                if(row[i] != '0') {
                    from_right[i] = Math.min(rightmost, from_right[i]);
                } else {
                    from_right[i] = w;//0;  Note that this  value will be used in the next line.
                    rightmost = i; //- 1;
                }
            }
            for(int i = 0; i < w; i++) {    
                ans = Math.max(ans, (from_right[i] - from_left[i]) * height[i]);
            }
        }
        return ans;
    }
    
}
