class Solution {
    private HashMap<Character, Integer> map = new HashMap<>();

    public Solution() {
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;  
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));

            if (i + 1 < s.length() && curr < map.get(s.charAt(i + 1))) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }
        return sum;
    }
}