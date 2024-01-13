/**
DFS와 BFS
https://www.acmicpc.net/problem/1260
*/

import java.util.*

fun main() {
    val (n, m, v) = readln().split(" ").map(String::toInt)
    val map = (1..n).zip(Array(n) { mutableListOf<Int>() }).toMap().apply {
        repeat(m) {
            readln().split(" ").map(String::toInt).also { (a, b) ->
                get(a)?.add(b)
                get(b)?.add(a)
            }
        }
        for (list in values) list.sort()
    }
    val dfsVisited = mutableSetOf(v)
    val bfsVisited = mutableSetOf(v)
    fun dfs(start: Int) {
        for (next in map.getOrDefault(start, mutableListOf())) {
            if (dfsVisited.contains(next)) continue
            dfsVisited.add(next)
            dfs(next)
        }
    }
    fun bfs(start: Int) {
        val queue = LinkedList(arrayListOf(start))

        while (queue.isNotEmpty()) {
            val outed = queue.poll()

            bfsVisited.add(outed)
            for (next in map.getOrDefault(outed, mutableListOf())) {
                if (!bfsVisited.contains(next) && !queue.contains(next)) queue.offer(next)
            }
        }
    }

    dfs(v)
    bfs(v)
    println(dfsVisited.joinToString(" "))
    println(bfsVisited.joinToString(" "))
}
