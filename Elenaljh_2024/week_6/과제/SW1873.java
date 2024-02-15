package 과제;
/*
상호의 배틀필드
 */
import java.io.*;
import java.util.*;
public class SW1873 {
    static int H, W, N, CX, CY; //CX: 전차 행, CY: 전차 열
    static char[][] map;
    static char tank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); //행
            W = Integer.parseInt(st.nextToken()); //열
            map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
                        tank = map[i][j];
                        CX = i; CY = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                play(str.charAt(i));
            }

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void play(char command) {
        if (command == 'U') {
            tank = '^';
            if (CX-1 >= 0 && map[CX-1][CY] == '.') {
                map[CX][CY] = '.';
                CX--;
            }
            map[CX][CY] = tank;
        }
        if (command == 'D') {
            tank = 'v';
            if (CX+1 < H && map[CX+1][CY] == '.') {
                map[CX][CY] = '.';
                CX++;
            }
            map[CX][CY] = tank;
        }
        if (command == 'L') {
            tank = '<';
            if (CY-1 >= 0 && map[CX][CY-1] == '.') {
                map[CX][CY] = '.';
                CY--;
            }
            map[CX][CY] = tank;
        }
        if (command == 'R') {
            tank = '>';
            if (CY+1 < W && map[CX][CY+1] == '.') {
                map[CX][CY] = '.';
                CY++;
            }
            map[CX][CY] = tank;
        }
        if (command == 'S') {
            destroy(tank);
        }
    }

    static void destroy(char tank) {
        if (tank == '^') {
            for (int i = 1; i <= CX; i++) {
                if (map[CX-i][CY] == '*') {
                    map[CX-i][CY] = '.';
                    break;
                }
                if (map[CX-i][CY] == '#') {
                    break;
                }
            }
        }
        if (tank == '<') {
            for (int i = 1; i <= CY; i++) {
                if (map[CX][CY-i] == '*') {
                    map[CX][CY-i] = '.';
                    break;
                }
                if (map[CX][CY-i] == '#') {
                    break;
                }
            }
        }
        if (tank == '>') {
            for (int i = 1; i < W-CY; i++) {
                if (map[CX][CY+i] == '*') {
                    map[CX][CY+i] = '.';
                    break;
                }
                if (map[CX][CY+i] == '#') {
                    break;
                }
            }
        }
        if (tank == 'v') {
            for (int i = 1; i < H-CX; i++) {
                if (map[CX+i][CY] == '*') {
                    map[CX+i][CY] = '.';
                    break;
                }
                if (map[CX+i][CY] == '#') {
                    break;
                }
            }
        }
    }
}
