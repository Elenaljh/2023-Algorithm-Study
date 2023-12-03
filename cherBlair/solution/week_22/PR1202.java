package week_22;

import java.util.Arrays;

public class PR1202 {

    // 특이한 정렬
    // https://school.programmers.co.kr/learn/courses/30/lessons/120880

    class Solution {
        public int[] solution(int[] numlist, int n) {
            Arrays.sort(numlist);

            for (int i = 0; i < numlist.length; i++) {
                for (int j = 0; j < numlist.length; j++) {
                    if (Math.abs(n - numlist[i]) <= Math.abs(n - numlist[j])) {
                        int temp = numlist[i];
                        numlist[i] = numlist[j];
                        numlist[j] = temp;
                    }
                }
            }
            return numlist;
        }
    }

    // 풀이 참고 - [ HP ]
    // import java.util.Arrays;
    //
    //class Solution {
    //    public int[] solution(int[] numList, int n) {
    //        return Arrays.stream(numList)
    //                .boxed()
    //                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
    //                .mapToInt(Integer::intValue)
    //                .toArray();
    //    }
    //}
}
