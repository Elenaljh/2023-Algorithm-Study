class Solution {
    int[] dp;
    public int solution(int x, int y, int n) {
          dp = new int[y + 1];
        for (int i = x + 1; i <= y; i++) {
            int a = i - n >= x ? dp[i - n] : Integer.MAX_VALUE;
            int b = i / 2 >= x && i % 2 == 0 ? dp[i / 2] : Integer.MAX_VALUE;
            int c = i / 3 >= x && i % 3 == 0 ? dp[i / 3] : Integer.MAX_VALUE;

            int d = Math.min(a, b);
            d = Math.min(d, c);

            dp[i] = (d < Integer.MAX_VALUE) ? d + 1 : Integer.MAX_VALUE;
        }
        return dp[y] < Integer.MAX_VALUE ? dp[y] : -1;
    }
  
}
