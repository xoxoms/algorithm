package bfs

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

/**
 * 133. Clone Graph
 * 초기값 1부터 인근 노드의 값을 순회하여 새로만들거나 memoization으로부터 반환받은 값을 사용한다.
 * 처리순서상 마지막 노드는 캐시에서 가져오고 쌓인 스택들은 체이닝을 반환하며 함수가 종료된다. DFS로 풀어버림
 */
class CloneGraph {
    private val visitedNodes = HashMap<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        node ?: return null
        return dfs(1, node)
    }

    private fun dfs(id: Int, node: Node): Node {
        if (!visitedNodes.contains(id)) { visitedNodes[id] = Node(id) }
        val result = visitedNodes[id]!!
        node.neighbors.forEach {
            result.neighbors.add(visitedNodes[it!!.`val`] ?: dfs(it.`val`, it))
        }

        return result
    }
}

fun  main() {
    val first = Node(1)
    val two = Node(2)
    val three = Node(3)
    first.neighbors.add(two)
    first.neighbors.add(three)
    two.neighbors.add(first)
    two.neighbors.add(three)
    three.neighbors.add(first)
    three.neighbors.add(two)
    val result = CloneGraph().cloneGraph(first)
    CloneGraph().cloneGraph(first)
}