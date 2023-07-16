from typing import List
from collections import deque

def bfs(start: List, end: List, marts: List) -> bool:
    q = deque()
    q.append(start)
    visited = []

    while q:
        now = q.popleft()
        if abs(now[0] - end[0]) + abs(now[1] - end[1]) <= 1000:
            return True

        for mart in marts:
            if abs(now[0] - mart[0]) + abs(now[1] - mart[1]) <= 1000 and mart not in visited:
                visited.append(mart)
                q.append(mart)

    return False


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        marts = []
        start = list(map(int, input().split()))
        for _ in range(n):
            x, y = map(int, input().split())
            marts.append([x, y])
        end = list(map(int, input().split()))

        if bfs(start, end, marts):
            print('happy')
        else:
            print('sad')
