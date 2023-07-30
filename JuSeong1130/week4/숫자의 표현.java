class Solution {
    int answer = 0;
    //10 5 6 4 5
    public int solution(int n) { 
        for(int i = 1; i <=n; i++) {
            recursion(i,0,n);
        }
        return answer;
    }
    public void recursion(int index,int sum,int n) {
        if(sum == n) {
            answer++;
            return;
        }
        if(sum > n) {
            return;
        }
        recursion(index+1,sum+index,n);
    }
}

/*
연속된 자연수들로 이루어져야함


*/
