package bfs

/**
 * 323. Number of Connected Components in an Undirected Graph !!
 * union find 라는 기법으로 해결한다.
 * 노드의 루트노드 값을 저장하는 parent 맵을 선언한다.
 * 루트노드의 하위 노드 갯수를 저장하는 rank 맵을 선언한다.
 * 간선을 순회하여 루트노드를 찾아 parent와 rank에 기록한다.
 * 만약 union하는 두 노드가 모두 루트노드라면, rank가 높은 값이 root가된다.
 */
class NumberOfConnectedComponents {

    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = mutableMapOf<Int, Int>()
        val rank = mutableMapOf<Int, Int>()
        for (i in 0 until n) {
            parent[i] = i
            rank[i] = 1
        }

        val find = { idx: Int ->
            var targetIndex = idx
            while (true) {
                val found = parent[targetIndex]!!
                if (found == targetIndex) {
                    break
                } else {
                    targetIndex = found
                }
            }

            targetIndex
        }

        val union = { idx1: Int, idx2: Int ->
            val idx1Parent= find(idx1)
            val idx2Parent= find(idx2)

            if (idx1Parent == idx2Parent) {
                0
            } else {
                if (rank[idx1Parent]!! < rank[idx2Parent]!!) {
                    rank[idx2Parent] = rank[idx2Parent]!! + 1
                    rank[idx1Parent] = 1
                    parent[idx1Parent] = idx2Parent
                } else {
                    rank[idx1Parent] = rank[idx1Parent]!! + 1
                    rank[idx2Parent] = 1
                    parent[idx2Parent] = idx1Parent
                }

                1
            }
        }

        var result = n
        for (edge in edges) {
            result -= union(edge[0], edge[1])
        }

        return result
    }
}

fun main() {
    println(
        NumberOfConnectedComponents().countComponents(
            5,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(2, 1),
                intArrayOf(2, 0),
                intArrayOf(2, 4),
            )
        )
    )
    println(
        NumberOfConnectedComponents().countComponents(
            5,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(3, 4),
            )
        )
    )
    println(
        NumberOfConnectedComponents().countComponents(
            5,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(0, 2),
                intArrayOf(3, 4),
            )
        )
    )
}
