/**
바이러스
https://www.acmicpc.net/problem/2606
*/

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val map = (1..n).associateWith { mutableListOf<Int>() }.apply {
        repeat(m) {
            readln().split(" ").map(String::toInt).also { (a, b) ->
                getOrDefault(a, mutableListOf()).add(b)
                getOrDefault(b, mutableListOf()).add(a)
            }
        }
    }
    val visited = mutableSetOf(1)
    fun dfs(v: Int) {
        for (next in map.getOrDefault(v, mutableListOf())) {
            if (visited.contains(next)) continue
            visited.add(next)
            dfs(next)
        }
    }

    dfs(1)
    println(visited.size - 1)
}
