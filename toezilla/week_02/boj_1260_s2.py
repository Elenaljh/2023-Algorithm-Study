import sys
from collections import deque

def dfs(x):
    global check_dfs
    global visited_dfs
    for i in range(n):
        if graph[x][i] == 1 and visited_dfs[x][i] == 0:
            if i+1 not in check_dfs:
                check_dfs.append(i+1)
            visited_dfs[x][i] = 1
            visited_dfs[i][x] = 1
            dfs(i)


def bfs(x):
    global check_bfs
    global visited_bfs
    queue = deque()
    queue.append(x)
    while queue:
        now = queue.popleft()
        for i in range(n):
            if graph[now][i] == 1 and visited_bfs[now][i] == 0:
                if i+1 not in check_bfs:
                    check_bfs.append(i+1)
                visited_bfs[now][i] = 1
                visited_bfs[i][now] = 1
                queue.append(i)


if __name__ == "__main__":
    sys.setrecursionlimit(10**5)
    n, m, v = map(int, input().split())
    graph = [[0] * n for _ in range(n)]
    visited_dfs = [[0] * n for _ in range(n)]
    visited_bfs = [[0] * n for _ in range(n)]
    check_dfs = [v]
    check_bfs = [v]

    for i in range(m):
        x, y = map(int, input().split())
        graph[y - 1][x - 1] = 1
        graph[x - 1][y - 1] = 1

    dfs(v-1)
    bfs(v-1)

    print(*check_dfs)
    print(*check_bfs)