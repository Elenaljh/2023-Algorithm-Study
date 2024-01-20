/**
안전 영역
https://www.acmicpc.net/problem/2468
*/

if
    let readln = readLine(),
    let n = Int(readln)
{
    let immutableArrays = (0..<n).compactMap { _ in readLine()?.split(separator: " ").compactMap { Int($0) } }
    let set = Set(immutableArrays.flatMap { $0 })
    var answer = 0
    
    for value in set {
        var arrays = getArrays(immutableArrays, value)
        var count = 0
        
        for i in arrays.indices {
            for j in arrays[i].indices where arrays[i][j] > 0 {
                count += 1
                dfs(&arrays, start: (i, j), limit: value)
            }
        }
        if count > 0 {
            answer = max(answer, count)
        }
    }
    print(max(answer, 1))
}

private func getArrays(_ arrays: [[Int]], _ n: Int) -> [[Int]] {
    var mutableArrays = arrays
    
    for i in mutableArrays.indices {
        for j in mutableArrays[i].indices {
            if mutableArrays[i][j] <= n {
                mutableArrays[i][j] = 0
            }
        }
    }
    return mutableArrays
}

private func dfs(_ arrays: inout [[Int]], start: (Int, Int), limit: Int) {
    var stack = [(Int, Int)]([start])
    arrays[start.0][start.1] = -1
    
    while !stack.isEmpty {
        let (outedI, outedJ) = stack.removeLast()
        
        for (nextI, nextJ) in [(outedI - 1, outedJ), (outedI, outedJ + 1), (outedI + 1, outedJ), (outedI, outedJ - 1)] {
            guard arrays.indices.contains(nextI) && arrays[0].indices.contains(nextJ) else {
                continue
            }
            if arrays[nextI][nextJ] > limit {
                arrays[nextI][nextJ] = -1
                
                stack.append((nextI, nextJ))
            }
        }
    }
}
