import java.util.*
import kotlin.math.max

class MaximumDepth {

    fun test(root: TreeNode?): Int {
        val queue = LinkedList<Pair<TreeNode?, Int>>()
        var depth = 0
        queue.add(Pair(root, 1))

        queue.pollFirst()

        while (queue.isNotEmpty()) {
            val polled = queue.pollFirst()
            polled.first?.let {
                depth = polled.second
                queue.add(Pair(it.left, depth + 1))
                queue.add(Pair(it.right, depth + 1))
            }
        }

        return depth
    }

    fun test2(root: TreeNode?): Int {
        if (root == null) return 0
        return recursive(root, 1)
    }

    private fun recursive(root: TreeNode?, depth: Int): Int {
        if (root?.left == null && root?.right == null) {
            return depth
        }

        val l = recursive(root.left, depth + 1)
        val r = recursive(root.right, depth + 1)
        return max(l, r)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n7 = TreeNode(7)
            val n15 = TreeNode(15)
            val n20 = TreeNode(20)
            val n9 = TreeNode(9)
            val n3 = TreeNode(1)
            n3.left = n9
            n3.right = n20
            n20.left = n15
            n20.right = n7

            println(MaximumDepth().test(n3))
        }
    }
}