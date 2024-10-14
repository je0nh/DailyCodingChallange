import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int high = Math.min(height[i], height[j]);
            int width = high * (j - i);
            if (answer < width) {
                answer = width;
            }

            if (height[i] < height[j]) {i++;}
            else if (height[i] > height[j]) {j--;}
            else {
                if (height[i + 1] < height[j - 1]) {i++;}
                else {j--;}
            }
        }
        return answer;
    }
}