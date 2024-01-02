package blair_2023.week_21;

public class PR1121 {

    // 💛직사각형의 넓이 구하기
    // https://school.programmers.co.kr/learn/courses/30/lessons/120860

    class Solution {
        public int solution(int[][] dots) {
            int w = 0;
            int h = 0;
            int x = dots[0][0];
            int y = dots[0][1];
            for (int i = 1; i < dots.length; i++) {
                if (x != dots[i][0]) w = Math.abs(x - dots[i][0]);
                if (y != dots[i][1]) h = Math.abs(y - dots[i][1]);
            }
            return w * h;
        }
    }


    // 다른 풀이 참고
    // class Solution {
    //    public int solution(int[][] dots) {
    //        int x = Math.max(Math.abs(dots[0][0] - dots[1][0]),Math.abs(dots[0][0] - dots[2][0]));
    //        int y = Math.max(Math.abs(dots[0][1] - dots[1][1]),Math.abs(dots[0][1] - dots[2][1]));
    //        return x*y;
    //    }
    //}
}
