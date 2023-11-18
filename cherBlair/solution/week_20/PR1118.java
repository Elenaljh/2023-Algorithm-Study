package week_20;

public class PR1118 {

    // 💛캐릭터의 좌표
    // https://school.programmers.co.kr/learn/courses/30/lessons/120861

    class Solution {
        public int[] solution(String[] keyinput, int[] board) {
            int[] answer = {0, 0};
            int width = board[0] / 2;
            int height = board[1] / 2;

            for (int i = 0; i < keyinput.length; i++) {
                if (keyinput[i].equals("left")) {
                    if (answer[0] > -(width)) answer[0] -= 1;
                } else if (keyinput[i].equals("right")) {
                    if (answer[0] < width) answer[0] += 1;
                } else if (keyinput[i].equals("down")) {
                    if (answer[1] > -(height)) answer[1] -= 1;
                } else if (keyinput[i].equals("up")) {
                    if (answer[1] < height) answer[1] += 1;
                }
            }
            return answer;
        }
    }

    // 다른 풀이 - "객체 지향적 코드"
    // import java.lang.Math;
    //class Solution {
    //    private String up = "up";
    //    private String down = "down";
    //    private String left = "left";
    //    private String right = "right";
    //    private int xPos = 0;
    //    private int yPos = 1;
    //    private int maxWidth = 0;
    //    private int maxHeight= 0;
    //    int[] answer = {0, 0};
    //
    //    public int[] solution(String[] keyinput, int[] board) {
    //        maxWidth = board[xPos] / 2;
    //        maxHeight = board[yPos] / 2;
    //        for (String moveKey : keyinput) {
    //            move(moveKey);
    //        }
    //        return answer;
    //    }
    //
    //    private void move(String key) {
    //        if (up.equals(key)) {
    //            // up
    //            moveUp();
    //        } else if (down.equals(key)) {
    //            // down
    //            moveDown();
    //        } else if (left.equals(key)) {
    //            // left
    //            moveLeft();
    //        } else {
    //            // right
    //            moveRight();
    //        }
    //    }
    //
    //    private void moveUp() {
    //        int top = Math.abs(maxHeight);
    //        if (answer[yPos] + 1 <= top) {
    //            answer[yPos]++;
    //        };
    //    }
    //
    //    private void moveDown() {
    //        int bottom = Math.abs(maxHeight) * -1;
    //        if (answer[yPos] - 1 >= bottom) {
    //            answer[yPos]--;
    //        };
    //    }
    //
    //    private void moveLeft() {
    //        int left = Math.abs(maxWidth) * -1;
    //        if (answer[xPos] - 1 >= left) {
    //            answer[xPos]--;
    //        };
    //    }
    //
    //    private void moveRight() {
    //        int right = Math.abs(maxWidth);
    //        if (answer[xPos] + 1 <= right) {
    //            answer[xPos]++;
    //        };
    //    }
    //}
}
