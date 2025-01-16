class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun make_3_9_20_15_7(): TreeNode {
            val root = TreeNode(3)
            val node1 = TreeNode(9)
            val node2 = TreeNode(20)
            val node3 = TreeNode(15)
            val node4 = TreeNode(7)

            root.left = node1
            root.right = node2
            node2.left = node3
            node2.right = node4

            return root
        }
    }
}

class BalancedBinaryTree {

    fun test(root: TreeNode?): Boolean {
        if (root == null) return false
        return recursive(root)
    }

    private fun recursive(root: TreeNode): Boolean {
        return if (root.left != null && root.right != null) {
            recursive(root.left!!) && recursive(root.right!!)
        } else if (root.left == null &&  root.right == null) {
            true
        } else {
            false
        }
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

            println(BalancedBinaryTree().test(n3))
        }
    }
}