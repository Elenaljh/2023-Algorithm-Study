package blair_2023.week_10;

import java.util.Arrays;

public class PR0903 {

    // 💛n의 배수 고르기

    // 문제 설명
    //  정수 n과 정수 배열 numlist가 매개변수로 주어질 때, numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    //  1 ≤ n ≤ 10,000
    //  1 ≤ numlist의 크기 ≤ 100
    //  1 ≤ numlist의 원소 ≤ 100,000

    class Solution {
        public int[] solution(int n, int[] numList) {
            return Arrays.stream(numList).filter(d -> d % n == 0).toArray();
        }
    }


    // 참고 코드
    // import java.util.List;
    //import java.util.ArrayList;
    //
    //class Solution {
    //    public int[] solution(int n, int[] numlist) {
    //        List<Integer> answer = new ArrayList<>();
    //        for(int num : numlist){
    //            if(num % n == 0){
    //                answer.add(num);
    //            }
    //        }
    //        return answer.stream().mapToInt(x -> x).toArray();
    //    }
    //}


    // 참고 코드 2
    // class Solution {
    //    public int[] solution(int n, int[] numlist) {
    //        int count = 0;
    //
    //        for(int i=0; i<numlist.length; i++) {
    //            if(numlist[i]%n==0){
    //                count++;
    //            }
    //        }
    //
    //        int[] answer = new int[count];
    //        int index=0;
    //        for(int i=0; i<numlist.length; i++) {
    //            if(numlist[i]%n==0){
    //                answer[index]=numlist[i];
    //                index++;
    //            }
    //        }
    //
    //        return answer;
    //    }
    //}
}
