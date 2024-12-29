package bfs

import java.util.*
import kotlin.collections.LinkedHashSet

class CourseSchedule2_bak {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        if (numCourses == 1) { return intArrayOf(0) }
        val visited = LinkedHashSet<Int>()
        if (prerequisites.isEmpty()) {
            for (i in 0 until numCourses) {
                visited.add(i)
            }

            return visited.toIntArray()
        }

        val queue = LinkedList<Pair<Int, Int>>()
        val edges = HashMap<Int, MutableList<Int>>()

        var i = 0
        for (j in prerequisites.indices) {
            val key = prerequisites[j][0]
            if (key > i) {
                for (k in i .. key) {
                    visited.add(k)
                }
            }
            i++

            edges.computeIfAbsent(prerequisites[j][0]) { mutableListOf() }
            edges[prerequisites[j][0]]!!.add(prerequisites[j][1])

            val q = LinkedList<Int>()
            q.add(prerequisites[j][1])
            while (q.isNotEmpty()) {
                val polled = q.poll()
                edges[polled]?.forEach {
                    if (it == prerequisites[j][0]) {
                        return intArrayOf(0)
                    }

                    q.add(it)
                }
            }

            queue.add(prerequisites[j][0] to prerequisites[j][1])
        }

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (visited.contains(polled.second)) {
                visited.add(polled.first)
            } else {
                queue.add(polled)
            }
        }

        return visited.toIntArray()
    }
}

fun main() {

    for (i in CourseSchedule2_bak().findOrder(
        2,
        arrayOf(
            intArrayOf(0, 1),
        )
    )) { print(i) }

    for (i in CourseSchedule2_bak().findOrder(
        3,
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 0),
        )
    )) { print(i) }
    println()
//
//    for (i in CourseSchedule2().findOrder(
//        4,
//        arrayOf(
//            intArrayOf(1, 0),
//            intArrayOf(2, 0),
//            intArrayOf(3, 1),
//            intArrayOf(3, 2),
//        )
//    )) { print(i) }
//    println()
}