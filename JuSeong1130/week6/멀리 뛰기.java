/*
전형적인 dp문제였다.
주어진조건값이 커서 완탐으로는 풀 수 없었고 dpfh 해결해야했다.

index에서작은값 5까지의 경우의 수를 구해보고 이후 규칙을 찾아 해결하였다
index 3의 값이 index2와 index 1 합친값이라는것을 발견하였고 이를 통해 해결하였다.
*/

class Solution {
    long ans = 0;
    public long solution(int n) {
        if(n == 1) {
            return 1;
        }
        long answer = 0;
        long[] dp = new long[n+1];
        init(dp,n);
        
        return dp[n];
    }
    public void init(long[] dp, int n) {

        dp[1] = 1L;
        dp[2] = 2L;
        for(int i = 3; i <=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
    }
    
    
    /*public void recursion(int sum, int n) {
        if(n < sum) {
            return;
        }
        if(n == sum) {
            ans++;
            return;
        }
        for(int i = 1 ; i <=2; i++) {
            recursion(sum+i,n);
        } 
    }*/
}
