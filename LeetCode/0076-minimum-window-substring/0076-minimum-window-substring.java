class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {return "";}

        int minStringLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int tLength = t.length();
        int[] minWindow = {0, Integer.MAX_VALUE};
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char rightChar = s.charAt(rightPointer);
            if (tMap.containsKey(rightChar) && tMap.get(rightChar) > 0) {
                tLength--;
            }
            tMap.put(rightChar, tMap.getOrDefault(rightChar, 0) - 1);

            // tLength == 0이라는 말은 t에들어가는 문자를 다 찾았다는 뜻
            // 그 상태에서 rightPointer을 고정시키고 leftPointer를 움직여서 글자의 시작점을 찾아야함
            if (tLength == 0) {
                // while을 통해 leftPointer를 움직이면서 만약 leftPointer로 찾은 문자가 t에 포함되어 있고 그 문자의 개수가 0이라면 while문을 멈춰서 leftPointer를 고정시켜줌
                while (true) {
                    char leftChar = s.charAt(leftPointer);
                    if (tMap.containsKey(leftChar) && tMap.get(leftChar) == 0) {
                        break;
                    }

                    tMap.put(leftChar, tMap.getOrDefault(leftChar, 0) + 1);
                    leftPointer++;
                }

                if (rightPointer - leftPointer < minWindow[1] - minWindow[0]) {
                    minWindow[0] = leftPointer;
                    minWindow[1] = rightPointer;
                }

                // 글자를 포함하는 길이를 다 찾았기 때문에 tMap에 s.charAt(leftPointer)에 해당하는 key의 값을 +1만큼해주고 leftPointer를 하나 넘겨줘서 다음번 tLength가 0일때 시작포인터의 역할을 할 수 있도록 해준다
                tMap.put(s.charAt(leftPointer), tMap.getOrDefault(s.charAt(leftPointer), 0) + 1);
                tLength++;
                leftPointer++;
            }
        }

        return minWindow[1] == Integer.MAX_VALUE? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }
}