class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < numbers.length -1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] > target) {
                    continue;
                } else if (numbers[i] + numbers[j] == target) {
                    System.out.println(numbers[i] + ", " + numbers[j]);
                    answer[0] = ++i;
                    answer[1] = ++j;
                    return answer;
                }
            }
        }
        return answer;
    }
}