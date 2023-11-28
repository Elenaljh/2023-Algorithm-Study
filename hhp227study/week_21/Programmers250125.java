/**
[PCCE 기출문제] 9번 / 이웃한 칸
https://school.programmers.co.kr/learn/courses/30/lessons/250125
*/

import java.util.stream.IntStream;

class Solution {
    public int solution(String[][] board, int h, int w) {
        return (int) IntStream.range(0, 4)
                .filter(i -> h + new int[] {0, 1, -1, 0}[i] >= 0 && h + new int[] {0, 1, -1, 0}[i] < board.length && w + new int[] {1, 0, 0, -1}[i] >= 0 && w + new int[] {1, 0, 0, -1}[i] < board.length)
                .filter(i -> board[h][w].equals(board[h + new int[] {0, 1, -1, 0}[i]][w + new int[] {1, 0, 0, -1}[i]]))
                .count();
    }
}
