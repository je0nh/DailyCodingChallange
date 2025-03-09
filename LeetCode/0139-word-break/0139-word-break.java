class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 단어의 길이보다 +1 만큼 더 긴 boolean 배열 생성
        boolean[] ans = new boolean[s.length() + 1];
        // 첫번째는 빈값이라 무조건 true
        ans[0] = true;

        for (int i = 0; i < s.length() + 1; i++) {
            // 아래의 반복문은 특정 단어가 wordDict에 들어있는지 찾을 수 있음
            // 예를 들어 applepenapple일 경우
            // 현재 i = ...pen까지라고 했을 때
            // p전까지는 wordDict.contains(s.substring(j, i)) 조건을 만족하지 못해서 지나감
            for (int j = 0; j < i; j++) {
                if (ans[j] && wordDict.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[s.length()];
    }
}