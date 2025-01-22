package top150

/**
 * 207. Course Schedule
 * 진입 간선이 0개인 노드를 구한다.
 * 해당 노드에서 향하는 간선을 제거한다.
 * 위를 반복한다.
 */
class CourseSchedule {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        var remaining = prerequisites.size
        val map1 = mutableMapOf<Int, MutableSet<Int>>()
        val map2 = mutableMapOf<Int, MutableSet<Int>>()

        for (i in 0 ..< numCourses) {
            map1.computeIfAbsent(i) { mutableSetOf() }
            map2.computeIfAbsent(i) { mutableSetOf() }
        }
        for (prerequisite in prerequisites) {
            map1[prerequisite[0]]!!.add(prerequisite[1])
            map2[prerequisite[1]]!!.add(prerequisite[0])
        }

        while (true) {
            val found = map1.entries.firstOrNull { it.value.size == 0 } ?: break
            map2[found.key]?.forEach {
                map1[it]!!.remove(found.key)
            }

            remaining -= map2[found.key]?.size ?: 0
            map1.remove(found.key)
        }

        return remaining == 0
    }
}

fun main() {
    println(
        CourseSchedule().canFinish(
            5,
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 4),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
            )
        )
    )
}