import java.util.*

class BinaryTreeLevelOrderTraversal {

    fun test(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        val result = mutableListOf<List<Int>>()

        while (queue.isNotEmpty()) {
            val size = queue.size

            val subset = mutableListOf<Int>()
            for (i in 0 until size) {
                val polled = queue.poll()
                subset.add(polled.`val`)
                polled?.let {
                    it.left?.let { l -> queue.offer(l) }
                    it.right?.let { r -> queue.offer(r) }
                }
            }
            result.add(subset)
        }

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n1 = TreeNode(1)
            val n7 = TreeNode(7)
            val n15 = TreeNode(15)
            val n20 = TreeNode(20)
            val n9 = TreeNode(9)
            val n3 = TreeNode(3)
            n3.left = n9
            n3.right = n20
            n20.left = n15
            n20.right = n7
            n9.left = n1

            print(BinaryTreeLevelOrderTraversal().test(n3))
        }
    }
}