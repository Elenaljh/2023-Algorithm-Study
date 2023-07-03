'''

2023-07-03
BOJ 1600: 말이 되고픈 원숭이

'''

from collections import deque


def bfs(x, y):
    global visited
    global k

    visited = [[[0] * (k + 1) for _ in range(w+1)] for _ in range(h + 1)]

    visited[0][0][k] = 1
    queue = deque()
    queue.append((x, y, k, 0))

    while queue:
        now = queue.popleft()
        xx = now[0]
        yy = now[1]

        if xx==w-1 and yy==h-1:
            print(now[3])
            break

        for i in range(8):
            next_x = xx+horse[i][0]
            next_y = yy+horse[i][1]

            if now[2]:
                if 0<=next_x<w and 0<=next_y<h and grid[next_y][next_x] == 0 and visited[next_y][next_x][now[2]-1] == 0:
                    visited[next_y][next_x][now[2]-1] = 1
                    queue.append((next_x, next_y, now[2]-1, now[3]+1))

        for i in range(4):
            next_x = xx + next[i][0]
            next_y = yy + next[i][1]
            if 0 <= next_x < w and 0 <= next_y < h and grid[next_y][next_x] == 0 and visited[next_y][next_x][now[2]] == 0:
                visited[next_y][next_x][now[2]] = 1
                queue.append((next_x, next_y, now[2], now[3]+1))
    
    else:
        print(-1)


if __name__ == "__main__":
    k = int(input())
    w, h = map(int, input().split())
    grid = []
    for _ in range(h):
        grid.append(list(map(int, input().split())))

    next = [(1,0), (-1,0), (0,1), (0,-1)]
    horse = [(2,1), (2,-1), (1,2), (1,-2), (-2,1), (-2,-1), (-1,2), (-1,-2)]
    bfs(0, 0)
