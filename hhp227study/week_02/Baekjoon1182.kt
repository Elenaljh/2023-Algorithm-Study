/**
부분수열의 합
https://www.acmicpc.net/problem/1182
*/

import java.util.Stack

fun main() {
    val (_, s) = readln().split(" ").map(String::toInt)
    val list = readln().split(" ").map(String::toInt)
    val stack = Stack<Int>()
    var count = 0
    fun backTracking(start: Int) {
        for (i in start until list.size) {
            if (stack.contains(i)) continue
            stack.push(i)
            if (stack.sumOf { list[it] } == s) count++
            if (stack.size != list.size) backTracking(i)
            stack.pop()
        }
    }

    backTracking(0)
    println(count)
}
