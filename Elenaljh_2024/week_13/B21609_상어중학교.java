import java.io.*;
import java.util.*;
public class B21609_상어중학교 {
    static int n, m, map[][], score;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static class Block {
        int x;
        int y;
        int numOfRainbow;
        List<Integer[]> list;
        public Block(int x, int y) {
            this.x = x;
            this.y = y;
            list = new ArrayList<>();
            numOfRainbow = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자 한 변의 길이
        m = Integer.parseInt(st.nextToken()); //색상의 개수
        map = new int[n][n];
        score = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int round = 0;
        while (true) {
//            System.out.println("round " + (++round));
            //가장 큰 블록 그룹 찾기
            Block maxBlock = getMaxBlock(); //null 반환시 루프 탈출
            if (maxBlock == null) break;
            //maxBlock 제거 + 점수 획득
            destroy(maxBlock);
            //확인
//            printMap("maxBlock제거");
            //중력 작용
            goDown();
            //확인
//            printMap("중력 작용");
            //90도 반시계방향 회전
            rotate();
            //확인
//            printMap("90도 반시계 회전");
            //중력 작용
            goDown();
            //확인
//            printMap("중력 작용");
        }

        System.out.println(score);


        /** 블록 색깔
         * 검은색 : -1
         * 무지개 : 0
         * 일반 : 1 ~ m
         */
        /** 규칙
         * 블록 그룹: 일반 블록의 색이 모두 같고 무지개는 포함해도 상관X. 검은 블록은 없어야함
         * 블록 그룹의 기준 블록 : 일반 블록 중 행의 번호가 가장 작음. 그런게 여러개면 열의 번호가 가장 작은 블록
         */
        /** 오토 플레이
         * 1. 크기가 가장 큰 블록 그룹을 찾는다. (크기 같다면 무지개 블록의 수가 가장 많은것, 같다면 기준 블록의 행이 가장 큰 것, 같다면 기준 블록의 열이 가장 큰것)
         * 2. 1의 블록 그룹을 제거. 블록 그룹에 포함된 블록의 수를 B라고 할 때 B^2점을 얻는다.
         * 3. 격자에 중력 작용 (남은 블록이 아래로 내려온다 - 검은색 블록 제외)
         * 4. 격자가 90도 반시계 방향으로 회전한다.
         * 5. 격자에 중력 작용 (남은 블록이 아래로 내려온다 - 검은색 블록 제외)
         * 6. 1~5 과정은 블록그룹이 존재하는 동안 계속해서 반복한다.
         */

    }
    //90도 반시계방향 회전
    static void rotate() {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[n-1-j][i] = map[i][j];
            }
        }
        map = newMap;
    }

    //격자에 중력 작용
    static void goDown() {
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            int start = n-1;
            for (int i = n-1; i >= 0; i--) {
                if (map[i][j] == -1) {
                    emptyStack(start, i, j, stack);
                    stack = new ArrayDeque<>();
                    start = i-1;
                } else {
                    if (map[i][j] != 9) {
                        stack.addLast(map[i][j]);
                    }
                }
            }
            emptyStack(start, -1, j, stack);
        }

    }
    //스택 털기
    static void emptyStack(int start, int end, int col, Deque<Integer> stack) {
        for (int i = start; i > end; i--) {
            if (!stack.isEmpty()) {
                map[i][col] = stack.pollFirst();
            } else {
                map[i][col] = 9;
            }
        }
    }

    //가장 큰 블록 그룹 구하기
    static void destroy(Block block) {
        for (Integer[] co : block.list) {
            map[co[0]][co[1]] = 9;
        }
        score += block.list.size() * block.list.size(); //점수 합산
    }

    //가장 큰 블록 그룹 구하기
    static Block getMaxBlock() {
        PriorityQueue<Block> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2.list.size() == o1.list.size() && o2.numOfRainbow == o1.numOfRainbow && o2.x == o1.x) {
                return o2.y - o1.y;
            } else if (o2.list.size() == o1.list.size() && o2.numOfRainbow == o1.numOfRainbow) {
                return o2.x - o1.x;
            } else if (o2.list.size() == o1.list.size()) {
                return o2.numOfRainbow - o1.numOfRainbow;
            } else {
                return o2.list.size() - o1.list.size();
            }
        });
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 1 && map[i][j] <= m && !visited[i][j]) {
                    Block block = bfs(i, j);
                    if (block != null) {
                        pq.add(block);
                    }
                }
            }
        }
        if (pq.isEmpty()) return null;
        return pq.poll();
    }

    //bfs
    static Block bfs(int x, int y) {
        Block block = new Block(x, y);
        block.list.add(new Integer[]{x, y});
        int color = map[x][y];
        visited[x][y] = true;
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{x, y});

        while (!q.isEmpty()) {
            Integer[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == color)) {
                        if (map[nx][ny] == 0) block.numOfRainbow++;
                        block.list.add(new Integer[]{nx, ny});
                        visited[nx][ny] = true;
                        q.add(new Integer[]{nx, ny});
                    }
                }
            }
        }
        //무지개블록 visited 해제
        for (Integer[] a : block.list) {
            if (map[a[0]][a[1]] == 0) {
                visited[a[0]][a[1]] = false;
            }
        }
        if (block.list.size() == 1) return null;
        return block;
    }

    //확인용 메서드
    static void printMap(String msg) {
        System.out.println(msg);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9) {
                    System.out.print("- ");
                } else {
                    System.out.print(map[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
