/**
저작권
https://www.acmicpc.net/problem/2914
*/

if
    let array = readLine()?.split(separator: " "),
    let a = Int(array[0]),
    let i = Int(array[1])
{
    print(a * (i - 1) + 1)
}
