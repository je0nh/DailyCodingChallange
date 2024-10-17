class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        if (s.length() == 0) {return answer;}

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println("=========================");
            char currentChar = s.charAt(i);
            System.out.println("current char: " + currentChar);

            int k = j;
            int count = 0;
            while (k < i) {
                char c = s.charAt(k);
                System.out.println(c);

                if (currentChar == c) {
                    j = k + 1;
                    System.out.println("j value: " + j);
                    break;
                }
                k++;
                count++;
            }

            System.out.println(count);
            answer = answer < count + 1? count + 1 : answer;
        }
        return answer;
    }
}