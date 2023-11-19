/**
숨바꼭질
https://www.acmicpc.net/problem/1697
*/

if
    let input = readLine()?.split(separator: " "),
    let n = Int(input[0]),
    let k = Int(input[1])
{
    var queue = [(n, 0)]
    var visited = Set<Int>([n])

    while !queue.isEmpty {
        let (outed, level) = queue.removeFirst()

        guard outed != k else {
            print(level)
            break
        }
        for next in [outed - 1, outed + 1, outed * 2] {
            if !visited.contains(next), next > -1, next < 100_001 {
                queue.append((next, level + 1))
                visited.insert(next)
            }
        }
    }
}
