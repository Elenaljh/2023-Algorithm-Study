/**
통나무 건너뛰기
https://www.acmicpc.net/problem/11497
*/

if
    let readln = readLine(),
    let t = Int(readln)
{
    for _ in 0..<t {
        guard let _ = readLine(), let reverseSortedArray = readLine()?.split(separator: " ").compactMap({ Int($0) }).sorted(by: >) else {
            break
        }
        var array = [Int]()
        
        for i in reverseSortedArray.indices {
            if i % 2 == 0 {
                array.insert(reverseSortedArray[i], at: 0)
            } else {
                array.append(reverseSortedArray[i])
            }
        }
        print(calculate(array))
    }
}

func calculate(_ array: [Int]) -> Int {
    var result = 0

    for i in 0..<array.count - 1 {
        result = max(result, abs(array[i] - array[i + 1]))
    }
    return result
}
