/**
음식물 피하기
https://www.acmicpc.net/problem/1743
*/

import kotlin.math.max

var count: Int = 0

var answer = 0

fun main() {
    val (n, m, k) = readln().split(" ").map(String::toInt)
    val array = Array(n + 2) { IntArray(m + 2) }.apply {
        repeat(k) {
            val (a, b) = readln().split(" ").map(String::toInt)
            this[a][b] = 1
        }
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (array[i][j] == 1) {
                count = 0

                search(i, j, array)
                if (answer != count) {
                    answer = max(answer, count)
                }
            }
        }
    }
    println(answer)
}

fun search(i: Int, j: Int, array: Array<IntArray>) {
    array[i][j] = 2
    count++

    if (array[i - 1][j] == 1) search(i - 1, j, array)
    if (array[i][j + 1] == 1) search(i, j + 1, array)
    if (array[i + 1][j] == 1) search(i + 1, j, array)
    if (array[i][j - 1] == 1) search(i, j - 1, array)
    if (array[i - 1][j] == 2 || array[i][j + 1] == 2 || array[i + 1][j] == 2 || array[i][j - 1] == 2) return
}
