package top150

/**
 * 210. Course Schedule II
 * 맵을 초기화한다.
 * 진입 간선이 0인 노드를 찾는다.
 * 결과 배열에 넣는다.
 * 해당 노드에서 출발한 선들을 지운다.
 * 위를 반복한다.
 * 진입 간선이 0인 노드가 없다면 빈 배열을 리턴한다.
 */
class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        val map1 = mutableMapOf<Int, MutableSet<Int>>()
        val map2 = mutableMapOf<Int, MutableSet<Int>>()
        for (i in 0..< numCourses) {
            map1[i] = hashSetOf()
            map2[i] = hashSetOf()
        }

        prerequisites.forEach {
            map1[it[0]]!!.add(it[1])
            map2[it[1]]!!.add(it[0])
        }

        while (true) {
            val found = map1.entries.firstOrNull { it.value.size == 0 } ?: break
            result.add(found.key)
            map2[found.key]?.forEach {
                map1[it]?.remove(found.key)
            }

            map1.remove(found.key)
        }

        return if (map1.all { it.value.size == 0 }) {
            result.toIntArray()
        } else {
            intArrayOf()
        }
    }
}

fun main() {
    CourseScheduleII().findOrder(
        4,
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2),
        ),
    )
}