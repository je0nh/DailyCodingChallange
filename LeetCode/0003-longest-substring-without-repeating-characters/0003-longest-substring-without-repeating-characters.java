class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        if (s.length() == 0) {return 0;}

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 1;

            System.out.println("============");
            System.out.println("current s: " + s.charAt(i));
            System.out.println("");
            for (int k = j; k < i; k++) {
                System.out.println("s.charAt(k): " + s.charAt(k));
                if (s.charAt(k) == s.charAt(i)) {
                    j = i;
                    break;
                }
                count++;
            }
            System.out.println("count: " + count);
            if (answer < count) {answer = count;}
        }
        return answer;
    }
}