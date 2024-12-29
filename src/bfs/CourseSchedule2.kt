package bfs

import java.util.*

/**
 * 210. Course Schedule II
 * 위상정렬(Topological sort)로 처리 가능한지 확인하여 해결해야한다.
 * 방식은,
 * 진입차수가 0인 노드를 큐에 넣고 해당 큐가 진입하는 간선을 제거한다.
 * 다시, 진입차수가 0인 노드를 확인해서 큐에 넣고 진입하여 위를 반복한다.
 * 만약, 최초 진입차수가 0인 노드가 없다면 위상정렬이 아니므로 얼리리턴할수있다.
 * 제거가능한 모든 간선을 제거한 후 진입차수가 남아있는 노드가 존재한다면 위상정렬의 조건에 위배된다.
 */
class CourseSchedule2 {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val idMap = prerequisites
            .groupBy { it[0] }
            .toMutableMap()
        val preIdMap = prerequisites
            .groupBy { it[1] }
            .toMutableMap()
        val result = mutableListOf<Int>()
        for (i in 0..<numCourses) {
            if (!idMap.containsKey(i)) {
                result.add(i)
            }
        }

        val queue = LinkedList<Int>()
        if (result.isNotEmpty()) {
            queue.addAll(result)
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                val target = preIdMap[polled] ?: continue
                target.forEach {
                    if (idMap[it[0]]!!.size == 1) {
                        queue.add(it[0])
                        result.add(it[0])
                    }
                    idMap[it[0]] = idMap[it[0]]!!.filterNot { item -> item[1] == polled }
                }
                preIdMap.remove(polled)
            }
        }

        if (result.size != numCourses) { return intArrayOf() }

        return result.toIntArray()
    }
}

fun main() {
    for (i in CourseSchedule2().findOrder(
        3,
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
        )
    )) { print(i) }
    println()

//    for (i in CourseSchedule2().findOrder(
//        3,
//        arrayOf(
//            intArrayOf(1, 0),
//            intArrayOf(1, 2),
//            intArrayOf(0, 1),
//        )
//    )) { print(i) }
//    println()

//    for (i in CourseSchedule2().findOrder(
//        2,
//        arrayOf(
//            intArrayOf(1, 0),
//        )
//    )) { print(i) }
//    println()

//    for (i in CourseSchedule2().findOrder(
//        2,
//        arrayOf(
//            intArrayOf(0, 1),
//        )
//    )) { print(i) }
//    println()

//    for (i in CourseSchedule2().findOrder(
//        3,
//        arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 2),
//            intArrayOf(2, 0),
//        )
//    )) { print(i) }
//    println()
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