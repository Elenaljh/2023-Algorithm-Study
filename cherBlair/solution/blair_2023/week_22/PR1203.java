package blair_2023.week_22;

public class PR1203 {

    // 최빈값 구하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120812

    class Solution {
        public int solution(int[] array) {
            int answer = array[0];
            int max = 0;
            int frequent[] = new int[1000];

            for (int i = 0; i < array.length; i++) {
                frequent[array[i]]++;

                if (max < frequent[array[i]]) {
                    max = frequent[array[i]];
                    answer = array[i];
                }
            }

            int temp = 0;
            for (int j = 0; j < 1000; j++) {
                if (max == frequent[j]) temp++;
                if (temp > 1) answer = -1;
            }
            return answer;
        }
    }

    // 다른 풀이 참고
    // import java.util.*;
    //class Solution {
    //    public int solution(int[] array) {
    //        int maxCount = 0;
    //        int answer = 0;
    //        Map<Integer, Integer> map = new HashMap<>();
    //        for(int number : array){
    //            int count = map.getOrDefault(number, 0) + 1;
    //            if(count > maxCount){
    //                maxCount = count;
    //                answer = number;
    //            }
    //            else  if(count == maxCount){
    //                answer = -1;
    //            }
    //            map.put(number, count);
    //        }
    //        return answer;
    //    }
    //}


    // 다른 풀이 참고 2 - [ HP ]
    // import java.util.List;
    //import java.util.Map;
    //import java.util.stream.Collectors;
    //import java.util.ArrayList;
    //import java.util.Arrays;
    //
    //class Solution {
    //    public int solution(int[] array) {
    //        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(Arrays.stream(array).boxed().collect(Collectors.groupingBy(o -> o)).entrySet()).stream().sorted((t0, t1) -> Integer.compare(t1.getValue().size(), t0.getValue().size())).collect(Collectors.toList());
    //        return list.size() > 1 && list.get(0).getValue().size() - list.get(1).getValue().size() == 0 ? -1 : list.get(0).getKey();
    //    }
    //}
}
