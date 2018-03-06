class Solution {
    public int lengthOfLongestSubstring(String s) {
        String str = s.toLowerCase();
        int[] c = new int[256];
        Arrays.fill(c,0);
        int j = 0;
        int i = 0;
        int max = 0;
        while (j < s.length()) {
            if (i < s.length() && c[s.charAt(i)] == 0) {
                c[s.charAt(i)] = 1;
                    i++;
            } 
            if (i == s.length() || c[s.charAt(i)] ==  1) {
                max = Math.max(max, i - j);
                c[s.charAt(j)] = 0;
                j++;
            }
        }
        return max;       
    }
    public static void main(String[] args) {
        String s = "sfsdcdw";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}