from collections import deque

if __name__ == "__main__":
    n, k = map(int, input().split())
    MAX = max(n, k)
    check = [-1]*(2*MAX+2)

    Queue = deque()
    Queue.append(n)
    check[n] = 0

    while Queue:
        now = Queue.popleft()
        if now == k:
            break
        else:
            if 2*now <= 2*MAX+1 and check[2*now]==-1:
                Queue.append(2*now)
                check[2*now] = check[now]+1

            if now+1 <= MAX and check[now+1] == -1:
                Queue.append(now+1)
                check[now+1] = check[now]+1

            if now-1 >= 0 and check[now-1]==-1:
                Queue.append(now-1)
                check[now-1] = check[now]+1
    print(check[k])