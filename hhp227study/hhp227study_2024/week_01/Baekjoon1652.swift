/**
누울 자리를 찾아라
https://www.acmicpc.net/problem/1652
*/

if let input = readLine(), let n = Int(input) {
    var rows = (0..<n).compactMap { _ in readLine() }
    var columns = (0..<n).map { i in String((0..<n).map { j in Array(rows[j])[i] }) }
    
    print(getAnswer(rows), getAnswer(columns))
}

private func getAnswer(_ array: [String]) -> Int {
    var count = 0

    for line in array {
        var continuousEmptySpace = 0

        for char in line {
            if char == "." {
                continuousEmptySpace += 1
            } else {
                if continuousEmptySpace > 1 {
                    count += 1
                }
                continuousEmptySpace = 0
            }
        }
        if continuousEmptySpace > 1 {
            count += 1
        }
    }
    return count
}
