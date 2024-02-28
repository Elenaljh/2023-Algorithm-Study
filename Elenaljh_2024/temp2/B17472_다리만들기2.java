import java.io.*;
import java.util.*;
public class B17472_다리만들기2 {
    static class Node {
        public int x, y;
        public Node parent;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    static class Edge implements Comparable<Edge> {
        public Node start, end;
        public int weight;

        public Edge(Node start, Node end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M, map[][], numberOfIslands;
    static Node[][] islands;
    static boolean[][] visited;
    static Queue<Node> q = new ArrayDeque<>();
    static List<Edge> edgeList = new ArrayList<>();
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        islands = new Node[N][M];
        numberOfIslands = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bfs 돌리면서 1로 표시된 부분은 node로 만들어주고 parent를 통해서 각 섬으로 나눔
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    numberOfIslands++;
                    Node n = new Node(i, j);
                    n.setParent(n);
                    islands[i][j] = n;
                    q.add(n);
                    visited[i][j] = true;
                    bfs();
                }
            }
        }


        //간선리스트 만들기
        findBridges();

        //크루스칼 알고리즘
        Collections.sort(edgeList); //간선리스트 오름차순 정렬

        int length = 0;
        int count = 0; //numberOfIslands-1이 될때까지만 돌린다.
        for (Edge edge : edgeList) {
            if (!union(edge.start, edge.end)) continue;
            length += edge.weight;
            if (++count == numberOfIslands-1) break;
        }

        if (count == numberOfIslands-1) {
            System.out.println(length);
        } else {
            System.out.println(-1);
        }

    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        Node newNode = new Node(nx, ny);
                        newNode.setParent(node.parent);
                        islands[nx][ny] = newNode;
                        q.add(newNode);
                    }
                }
            }
        }
    }

    static boolean union(Node a, Node b) {
        Node rootA = find(a);
        Node rootB = find(b);
        if (rootA.equals(rootB)) return false;
        rootB.parent = rootA.parent;
        return true;
    }

    static Node find(Node a) {
        if (a.parent.equals(a)) return a;
        return a.parent = find(a.parent);
    }

    static boolean areSameIslands(Node a, Node b) {
        if (a.parent.equals(b.parent)) return true;
        return false;
    }

    //간선리스트 만들기
    static void findBridges() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (map[nx][ny] == 0) { //섬 가장자리라면
                                //해당 방향으로 쭉 나아갔을 때 다리 만들 수 있는지 체크
                                addEdges(islands[i][j], k);
                            }
                        }

                    }
                }

            }
        }
    }

    static void addEdges(Node now, int direction) {
        int length = 0;
        int nx = now.x + dx[direction];
        int ny = now.y + dy[direction];
        Node island = null;
        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (map[nx][ny] == 0) {
                length++;
            }
            if (map[nx][ny] == 1) {
                island = islands[nx][ny];
                break;
            }
            nx += dx[direction]; ny += dy[direction];
        }
        if (island != null && !areSameIslands(now, island)) {
            if (length > 1) {
                edgeList.add(new Edge(now, island, length));
            }
        }
    }

}
