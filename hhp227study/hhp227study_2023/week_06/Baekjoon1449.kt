/**
수리공 항승
https://www.acmicpc.net/problem/1449
*/

fun main() {
    val (_, l) = readln().split(" ").map(String::toInt)
    val list = readln().split(" ").map(String::toInt).sorted()
    var answer = 0
    var start = 0

    while (start < list.size) {
        val next = list.indexOfFirst { it > list[start] + l - 1 }
        answer++
        if (next > -1) start = next
        else break
    }
    println(answer)
}
