package blair_2023.week_24;

public class Daily1212 {

    // 평행
    // https://school.programmers.co.kr/learn/courses/30/lessons/120875

    public int solution(int[][] dots) {
        int answer = 0;

        if (calcSlope(dots[0], dots[1]) == calcSlope(dots[2], dots[3])) {
            return 1;
        }
        if (calcSlope(dots[0], dots[2]) == calcSlope(dots[1], dots[3])) {
            return 1;
        }
        if (calcSlope(dots[0], dots[3]) == calcSlope(dots[1], dots[2])) {
            return 1;
        }
        return answer;
    }

    public double calcSlope(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }

    // 다른 풀이 참고
    // import java.lang.Math;
    //class Solution {
    //    private int xPos = 0;
    //    private int yPos = 1;
    //    private int[][] checkCases = {{0, 1, 2, 3}, {0, 2, 1, 3}, {0, 3, 1, 2}};
    //    public int solution(int[][] dots) {
    //        int answer = 0;
    //        for (int[] checkCase : checkCases) {
    //            if (checkParallel(checkCase, dots)) {
    //                answer = 1;
    //                break;
    //            }
    //        }
    //
    //        return answer;
    //    }
    //
    //    private boolean checkParallel(int[] checkCase, int[][] dots) {
    //        int xPos1 = dots[checkCase[0]][xPos];
    //        int yPos1 = dots[checkCase[0]][yPos];
    //        int xPos2 = dots[checkCase[1]][xPos];
    //        int yPos2 = dots[checkCase[1]][yPos];
    //        int xPos3 = dots[checkCase[2]][xPos];
    //        int yPos3 = dots[checkCase[2]][yPos];
    //        int xPos4 = dots[checkCase[3]][xPos];
    //        int yPos4 = dots[checkCase[3]][yPos];
    //        // (y4 - y3)(x2 - x1) - (x4 - x3)(y2 - y1) 평행여부 조건
    //        int chk = ((yPos4 - yPos3) * (xPos2 - xPos1)) - ((xPos4 - xPos3) * (yPos2 - yPos1));
    //        if (chk == 0) {
    //            return true;
    //        }
    //        return false;
    //    }
    //}
}
