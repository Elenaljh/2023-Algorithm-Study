/**
뒤집기
https://www.acmicpc.net/problem/1439
*/

if
    let inputs = readLine()
{
    let split0 = inputs.split(separator: "0")
    let split1 = inputs.split(separator: "1")
    
    print(min(split0.count, split1.count))
}
