package blair_2023.week_18;

import java.util.HashSet;

public class PR1101 {

    // 💛 소인수 분해
    // https://school.programmers.co.kr/learn/courses/30/lessons/120852
    // 문제 설명
    // 소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다.
    // 따라서 12의 소인수는 2와 3입니다. 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

    // 제한사항
    // 2 ≤ n ≤ 10,000

    class Solution {
        public int[] solution(int n) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    set.add(i);
                    n /= i;
                }
            }
            if (n != 1) set.add(n);

            return set.stream().mapToInt(Integer::intValue).sorted().toArray();
        }
    }

    // 다른 풀이
    // import java.util.LinkedHashSet;
    //
    //class Solution {
    //    public int[] solution(int n) {
    //        LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();
    //
    //        int i = 2;
    //        while (n != 0 && i <= n) {
    //            if (n % i == 0) {
    //                primeNumbers.add(i);
    //                n /= i;
    //            } else {
    //                i++;
    //            }
    //        }
    //
    ////        System.out.println(primeNumbers);
    //
    //        return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
    //    }
    //}

}
