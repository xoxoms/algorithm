package bfs

/**
 * 310. Minimum Height Trees !!
 * 리프 노드들을 하나씩 제거하다보면 root가 나온다.
 * root는 1개 혹은 2개이다. 노드간 간선은 한개이므로 unique path로 연결되어있기 때문에 3개 이상의 루트가 존재할 수 없다.
 */
class MinimumHeightTrees {

    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) { return listOf(0) }

        val map = mutableMapOf<Int, MutableSet<Int>>()
        edges.forEach { edge ->
            map.computeIfAbsent(edge[0]){ mutableSetOf()}.add(edge[1])
            map.computeIfAbsent(edge[1]){ mutableSetOf()}.add(edge[0])
        }

        while (true) {
            if (map.size <= 2) { return map.keys.toList() }

            val leaves = map.filter { it.value.size == 1 }.keys
            leaves.forEach { leaf ->
                val target = map[leaf]!!
                for (t in target) {
                    map[t]!!.remove(leaf)
                }

                map.remove(leaf)
            }
        }
    }
}

fun main() {
//    println(
//        MinimumHeightTrees().findMinHeightTrees(
//            n = 6,
//            edges = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(0, 2),
//                intArrayOf(0, 3),
//                intArrayOf(3, 4),
//                intArrayOf(4, 5),
//            )
//        )
//    )
    println(
        MinimumHeightTrees().findMinHeightTrees(
            n = 3,
            edges = arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
            )
        )
    )
//    println(
//        MinimumHeightTrees().findMinHeightTrees(
//            n = 6,
//            edges = arrayOf(
//                intArrayOf(3, 0),
//                intArrayOf(3, 1),
//                intArrayOf(3, 2),
//                intArrayOf(3, 4),
//                intArrayOf(5, 4),
//            )
//        )
//    )
}