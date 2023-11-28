/**
[PCCE 기출문제] 10번 / 데이터 분석
https://school.programmers.co.kr/learn/courses/30/lessons/250121
*/

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
                .filter(ints -> (ext.equals("code") ? ints[0] : ext.equals("date") ? ints[1] : ext.equals("maximum") ? ints[2] : ints[3]) < val_ext)
                .sorted(Comparator.comparing(ints -> sort_by.equals("code") ? ints[0] : sort_by.equals("date") ? ints[1] : sort_by.equals("maximum") ? ints[2] : ints[3]))
                .toArray(int[][]::new);
    }
}
