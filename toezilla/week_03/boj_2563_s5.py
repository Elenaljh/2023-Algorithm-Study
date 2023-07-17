'''
2023-07-17
BOJ 2563: 색종이
'''

if __name__ == "__main__":
    # 풀이 - 완전탐색
    ### 시간복잡도: N * 100
    ### 최대 시간복잡도: 1만

    n = int(input())
    grid = [[0] * 100 for _ in range(100)]

    for _ in range(n):
        x, y = map(int, input().split())
        for i in range(x, x+10):
            for j in range(y, y+10):
                grid[j][i] = 1

    res = 0
    for i in range(100):
        for j in range(100):
            if grid[j][i] == 1:
                res += 1

    print(res)

