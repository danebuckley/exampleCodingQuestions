class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int Lo = 0;
        int Hi = height.length-1;
        while (Lo != Hi) {
            if (height[Lo] <= height[Hi]) {
                max = Math.max(max, height[Lo]*(Hi-Lo));
                Lo++;
            } else {
                max = Math.max(max, height[Hi]*(Hi-Lo));
                Hi--;
            }
        }
        
        return max;
    }
}