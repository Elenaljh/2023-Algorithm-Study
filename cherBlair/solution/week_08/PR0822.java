package week_08;

public class PR0822 {

    // 💛중복된 숫자 개수
    // 정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때, array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.

    // 제한사항
    //  1 ≤ array의 길이 ≤ 100
    //  0 ≤ array의 원소 ≤ 1,000
    //  0 ≤ n ≤ 1,000

    class Solution {
        public int solution(int[] array, int n) {
            int answer = 0;

            for (int comparable : array) {
                if (comparable == n) {
                    answer++;
                }
            }

            return answer;
        }
    }

    // 참고 풀이 - stream
//    import java.util.Arrays;
//    class Solution {
//        public int solution(int[] array, int n) {
//            return (int) Arrays.stream(array).filter(i -> i == n).count();
//        }
//    }
}
