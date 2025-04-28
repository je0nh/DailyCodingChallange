class Solution {
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        // System.out.println(Arrays.toString(list));

        String ans = "";
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].equals("")) continue;
            ans += list[i].trim() + " ";
        }
        return ans.trim();
    }
}