class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (true) {
            if (numbers[i] + numbers[j] == target) {
                answer[0] = ++i;
                answer[1] = ++j;
                return answer;
            }

            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
    }
}