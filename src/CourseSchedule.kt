import kotlin.math.max

class CourseSchedule {

    fun test(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val idMap = prerequisites.groupBy({ it[0] })
        val resultMap = IntArray(max(numCourses, prerequisites.size)) { -1 }
        for (i in 0 until numCourses) {
            if (!recursive(i, idMap, resultMap, mutableSetOf())) return false
        }

        return true
    }

    fun recursive(id: Int, idMap: Map<Int, List<IntArray>>, resultMap: IntArray, queue: MutableSet<Int>): Boolean {
        if (queue.contains(id)) return resultMap[id] == 1
        else {queue.add(id)}
        return if (resultMap[id] == -1) {
            val idGroup = idMap[id]
            if (idGroup == null) {
                resultMap[id] = 1
                true
            } else {
               idGroup.forEach {
                   if (!recursive(it[1], idMap, resultMap, queue)) {
                       return false
                   }
               }
                resultMap[id] = 1
                return true
            }
        } else {
            true
        }
    }

    fun test2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val idMap = prerequisites.groupBy({ it[0] })
        val maxSize = max(numCourses, prerequisites.size)
        val resultMap = IntArray(maxSize) { -1 }
        val queue = mutableSetOf<Int>()

        for (i in 0 until numCourses) {
            queue.clear()
            recursive2(i, idMap, resultMap, queue)
            if (resultMap[i] != 1) {
                return false
            }
        }

        return true
    }

    private fun recursive2(id: Int, idGroupMap: Map<Int, List<IntArray>>, resultMap: IntArray, queue: MutableSet<Int>) {
        if (queue.contains(id)) {
            return
        } else {
            queue.add(id)
        }

        if (resultMap[id] == -1) {
            val idGroup = idGroupMap[id]
            if (idGroup == null) {
                resultMap[id] = 1
            } else {
                idGroup.forEach { recursive(it[1], idGroupMap, resultMap, queue) }
                if (idGroup.all { resultMap[it[1]] == 1 }) {
                    resultMap[id] = 1
                }
            }
        } else {
            return
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CourseSchedule().test(
                numCourses = 3,
                prerequisites = arrayOf(
                    intArrayOf(0,1),
                    intArrayOf(0,2),
                    intArrayOf(1,2),
                )
            )
//            CourseSchedule().test(
//                numCourses = 5,
//                prerequisites = arrayOf(
//                    intArrayOf(1,4),
//                    intArrayOf(2,4),
//                    intArrayOf(3,1),
//                    intArrayOf(3,2),
//                )
//            )
//            CourseSchedule().test(
//                numCourses = 3,
//                prerequisites = arrayOf(
//                    intArrayOf(0,1),
//                    intArrayOf(1,2),
//                )
//            )
//            CourseSchedule().test(
//                numCourses = 7,
//                prerequisites = arrayOf(
//                    intArrayOf(1,0),
//                    intArrayOf(0,3),
//                    intArrayOf(0,2),
//                    intArrayOf(3,2),
//                    intArrayOf(2,5),
//                    intArrayOf(4,5),
//                    intArrayOf(5,6),
//                    intArrayOf(2,4),
//                )
//            )
//            CourseSchedule().test(
//                numCourses = 2,
//                prerequisites = arrayOf(
//                    intArrayOf(1, 0),
//                )
//            )
//            CourseSchedule().test(
//                numCourses = 3,
//                prerequisites = arrayOf(
//                    intArrayOf(1, 0),
//                    intArrayOf(1, 2),
//                    intArrayOf(0, 1),
//                )
//            )
//            CourseSchedule().test(
//                numCourses = 2,
//                prerequisites = arrayOf(
//                    intArrayOf(0, 1),
//                    intArrayOf(1, 0),
//                )
//            )
        }
    }
}