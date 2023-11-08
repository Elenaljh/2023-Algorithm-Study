package week_19;

public class PR1107 {

    // 💛구슬을 나누는 경우의 수
    // https://school.programmers.co.kr/learn/courses/30/lessons/120840
    // 문제 설명
    // 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다.
    // 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때,
    // balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

    // 제한사항
    // 1 ≤ balls ≤ 30
    // 1 ≤ share ≤ 30
    // 구슬을 고르는 순서는 고려하지 않습니다.
    // share ≤ balls

    class Solution {
        public int solution(int balls, int share) {
            long answer = 1;
            int shareIndex = 1;

            for (int i = share + 1; i <= balls; i++) {
                answer *= i;
                answer /= shareIndex;
                shareIndex++;
            }

            return (int) answer;
        }
    }

    // 다른 풀이 1 - 재귀함수
    // class Solution {
    //    public long solution(int balls, int share) {
    //        share = Math.min(balls - share, share);
    //
    //        if (share == 0)
    //            return 1;
    //
    //        long result = solution(balls - 1, share - 1);
    //        result *= balls;
    //        result /= share;
    //
    //        return result;
    //    }
    //}

    // 다른 풀이 2 - 함수 따로 빼기
    // import java.math.BigInteger;
    //
    //class Solution {
    //
    //    public long solution(int balls, int share) {
    //        return getFactorial(balls, balls - share).divide(new BigInteger(String.valueOf(getFactorial(share)))).longValue();
    //    }
    //
    //    private BigInteger getFactorial(int n, int m) {
    //        BigInteger result = new BigInteger(String.valueOf(n));
    //
    //        for (int i = n - 1; i > m; i--) {
    //            result = result.multiply(new BigInteger(String.valueOf(i)));
    //        }
    //
    //        return result;
    //    }
    //
    //    private int getFactorial(int n) {
    //        int result = 1;
    //        for (int i = n; i > 1; i--) {
    //            result *= i;
    //        }
    //
    //        return result;
    //    }
    //}

    // 다른 풀이 3 - BigInteger
    // import java.math.*;
    //class Solution {
    //    public BigInteger solution(int balls, int share) {
    //        return factor(balls).divide(factor(balls - share).multiply(factor(share)));
    //    }
    //    public BigInteger factor(int num){
    //        BigInteger ret = new BigInteger("1");
    //        BigInteger from = new BigInteger("1");
    //        BigInteger to = new BigInteger(String.valueOf(num));
    //        for(BigInteger i = from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE)){
    //            ret = ret.multiply(i);
    //        }
    //        return ret;
    //    }
    //}
}
