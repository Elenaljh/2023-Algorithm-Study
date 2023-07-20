'''
2023-07-20
BOJ 2564: 경비원
'''

if __name__ == "__main__":
    # 풀이 - 단순구현
    ### 시간복잡도: X
    ### 최대 시간복잡도: X

    north = []
    south = []
    west = []
    east = []

    length, height = map(int, input().split())
    n = int(input())

    for _ in range(n):
        direction, vector = map(int, input().split())
        if direction == 1:
            north.append(vector)
        elif direction == 2:
            south.append(vector)
        elif direction == 3:
            west.append(vector)
        else:
            east.append(vector)

    main_direction, main_vector = map(int, input().split())

    if main_direction == 1:
        for i, vector in enumerate(north):
            north[i] = abs(vector - main_vector)
        for i, vector in enumerate(south):
            south[i] = height + min((vector + main_vector), (2 * length - vector - main_vector))
        for i, vector in enumerate(west):
            west[i] = main_vector + vector
        for i, vector in enumerate(east):
            east[i] = length - main_vector + vector

    elif main_direction == 2:
        for i, vector in enumerate(north):
            north[i] = height + min((vector + main_vector), (2 * length - vector - main_vector))
        for i, vector in enumerate(south):
            south[i] = abs(vector - main_vector)
        for i, vector in enumerate(west):
            west[i] = main_vector + height - vector
        for i, vector in enumerate(east):
            east[i] = length - main_vector + height - vector

    elif main_direction == 3:
        for i, vector in enumerate(north):
            north[i] = main_vector + vector
        for i, vector in enumerate(south):
            south[i] = height - main_vector + vector
        for i, vector in enumerate(west):
            west[i] = abs(main_vector - vector)
        for i, vector in enumerate(east):
            east[i] = length + min((main_vector + vector), (2 * height - main_vector -vector))

    else:
        for i, vector in enumerate(north):
            north[i] = main_vector + length - vector
        for i, vector in enumerate(south):
            south[i] = height - main_vector + length - vector
        for i, vector in enumerate(west):
            west[i] = length + min((main_vector + vector), (2 * height - main_vector - vector))
        for i, vector in enumerate(east):
            east[i] = abs(main_vector - vector)

    res = sum(north) + sum(south) + sum(east) + sum(west)
    print(res)

