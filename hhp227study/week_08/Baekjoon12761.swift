/**
돌다리
https://www.acmicpc.net/problem/12761
*/

if
    let inputs = readLine()?.split(separator: " "),
    let a = Int(inputs[0]),
    let b = Int(inputs[1]),
    let n = Int(inputs[2]),
    let m = Int(inputs[3])
{
    var queue = [(n, 0)]
    var visited = Set<Int>()
    
    while !queue.isEmpty {
        let (outed, level) = queue.removeFirst()
        
        guard outed != m else {
            print(level)
            break
        }
        for next in [outed - 1, outed + 1, outed - a, outed + a, outed - b, outed + b, outed * a, outed * b] {
            if !visited.contains(next), next > -1, next <= 100_000 {
                queue.append((next, level + 1))
                visited.insert(next)
            }
        }
    }
}
