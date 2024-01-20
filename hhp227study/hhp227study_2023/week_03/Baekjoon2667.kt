/**
단지번호붙이기
https://www.acmicpc.net/problem/2667
*/

fun main() {
    val n = readln().toInt()
    val array = Array(n + 2) {
        if (it in 1..n)
            "0${readln()}0".split("").filter(String::isNotEmpty).map(String::toInt).toIntArray()
        else
            IntArray(n + 2)
    }
    val list = mutableListOf<Int>()
    var count = 0
    fun search(i: Int, j: Int, array: Array<IntArray>) {
        array[i][j] = 2
        count++

        if (array[i - 1][j] == 1) search(i - 1, j, array)
        if (array[i][j + 1] == 1) search(i, j + 1, array)
        if (array[i + 1][j] == 1) search(i + 1, j, array)
        if (array[i][j - 1] == 1) search(i, j - 1, array)
        if (array[i - 1][j] == 2 || array[i][j + 1] == 2 || array[i + 1][j] == 2 || array[i][j - 1] == 2) return
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (array[i][j] == 1) {
                count = 0

                search(i, j, array)
                list.add(count)
            }
        }
    }
    println(list.size)
    for (answer in list.sorted()) {
        println(answer)
    }
}
