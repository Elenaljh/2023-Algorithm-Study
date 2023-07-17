import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < computers.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if(visited[i] == false) {
                answer++;
                visited[i] = true;
                for(int j = 0; j < computers[0].length; j++) {
                    if(i != j && computers[i][j] == 1) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            while(!queue.isEmpty()) {
                int x = queue.poll();
                for(int y = 0; y < computers[0].length; y++) {
                    if(computers[x][y] == 1 && visited[y] == false) {
                        queue.add(y);
                        visited[y] = true;
                    }
                }
            }
            
         }
        return answer;
    }
}

// 여기서 핵심 이미연결되어있는거 다시안하게 해야함
