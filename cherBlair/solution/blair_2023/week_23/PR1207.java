package blair_2023.week_23;

public class PR1207 {

    // 안전지대
    // https://school.programmers.co.kr/learn/courses/30/lessons/120866

    class Solution {
        public int solution(int[][] board) {
            int[][] boomBoard = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) checkExplosionSpot(i, j, boomBoard);
                }
            }
            int count = 0;
            for (int[] array : boomBoard) {
                for (int value : array) {
                    if (value == 0) count++;
                }
            }
            return count;
        }

        public void checkExplosionSpot(int x, int y, int[][] boomBoard) {
            int explosionX;
            int explosionY;
            int[] aroundX = {0, -1, -1, -1, 0, 0, 1, 1, 1};
            int[] aroundY = {0, -1, 0, 1, -1, 1, -1, 0, 1};
            for (int i = 0; i < 9; i++) {
                explosionX = x + aroundX[i];
                explosionY = y + aroundY[i];
                if (explosionX < boomBoard.length && explosionY < boomBoard.length)
                    if (explosionX >= 0 && explosionY >= 0) boomBoard[explosionX][explosionY] = 1;
            }
        }
    }
}
