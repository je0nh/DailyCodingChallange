import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList();

        for (int n : nums) {
            // 들어갈 자리를 알려줌
            // - 값이면 값이 존재하지 않는다는 뜻
            int idx = Collections.binarySearch(ans, n);
            // System.out.println(idx);

            if (idx < 0) {
                idx = -1 * (idx + 1);
            }
            
            if (idx < ans.size()) {
                ans.set(idx, n);
            } else {
                ans.add(n);
            }
        }
        return ans.size();
    }
}