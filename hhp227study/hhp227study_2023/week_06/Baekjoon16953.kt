/**
A → B
https://www.acmicpc.net/problem/16953
*/

fun main() {
    var (a, b) = readln().split(" ").map(String::toInt)
    var answer = 1

    while (a != b) {
        answer++
        when {
            b % 10 == 1 -> b /= 10
            b % 2 == 0 -> b /= 2
            else -> {
                answer = -1
                break
            }
        }
        if (a > b) {
            answer = -1
            break
        }
    }
    println(answer)
}
