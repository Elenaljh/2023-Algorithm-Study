/**
모든 순열
https://www.acmicpc.net/problem/10974
*/

import java.util.*

fun main() {
    val n = readln().toInt()

    permutation(Stack(), n)
}

private fun permutation(stack: Stack<Int>, n: Int) {
    for (i in 1..n) {
        if (stack.contains(i)) continue
        stack.push(i)
        if (stack.size != n) {
            permutation(stack, n)
        } else {
            println(stack.joinToString(" "))
        }
        stack.pop()
    }
}
