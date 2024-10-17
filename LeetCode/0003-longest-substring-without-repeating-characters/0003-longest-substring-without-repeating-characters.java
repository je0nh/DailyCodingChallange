class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        if (s.length() == 0) {return answer;}

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int k = j;
            int count = 0;
            while (k < i) {
                char c = s.charAt(k);
                if (currentChar == c) {
                    j = k + 1;
                    break;
                }
                k++;
                count++;
            }
            answer = answer < count + 1? count + 1 : answer;
        }
        return answer;
    }
}