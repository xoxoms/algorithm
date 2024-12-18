package bfs

/**
 * 116. Populating Next Right Pointers in Each Node
 * root가 null이 아닐때까지 왼쪽은 오른쪽을 오른쪽은 루트.넥스트.왼쪽을 할당
 */
class Populating {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root != null) {
            root.left?.next = root.right
            root.right?.next = root.next?.left
            connect(root.left)
            connect(root.right)
        }

        return root
    }

    private fun dfs(left: Node?, right: Node?) {
        if (left == null && right == null) return
        left!!.next = right
    }
}

fun main() {
    val root = Populating.Node(1)
    println(Populating().connect(root = root))
}