package 스터디;
/*
감시
https://www.acmicpc.net/problem/15683
 */
import java.util.*;
import java.io.*;

public class B15683 {
    static int n, m, map[][];
    static cctv[] cameras;

    static class cctv {
        public int x, y;
        public int direction;
        public int type; //1~5

        public cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {

    }


}
