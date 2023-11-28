/**
[PCCP 기출문제] 2번
https://school.programmers.co.kr/learn/courses/30/lessons/250136
*/

import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int key = 1;
        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) memo.put(++key, dfsAndGetSearchCount(land, new int[] {i, j}, key));
            }
        }
        for (int i = 0; i < land[0].length; i++) {
            int count = 0;
            Set<Integer> set = new HashSet<>();

            for (int[] ints : land) {
                set.add(ints[i]);
            }
            for (int e : set) if (e > 0) {
                count += memo.get(e);
            }
            if (count > 0) answer = Math.max(answer, count);
        }
        return answer;
    }

    private int dfsAndGetSearchCount(int[][] array, int[] start, int key) {
        int count = 1;
        Stack<int[]> stack = new Stack<>() { { push(start); } };
        array[start[0]][start[1]] = key;

        while (!stack.isEmpty()) {
            int[] outed = stack.pop();

            for (int[] next : new int[][] {{outed[0] - 1, outed[1]}, {outed[0], outed[1] + 1}, {outed[0] + 1, outed[1]}, {outed[0], outed[1] - 1}}) {
                if (next[0] < 0 || next[0] >= array.length || next[1] < 0 || next[1] >= array[0].length) continue;
                if (array[next[0]][next[1]] == 1) {
                    array[next[0]][next[1]] = key;
                    count++;
                    stack.push(next);
                }
            }
        }
        return count;
    }
}
