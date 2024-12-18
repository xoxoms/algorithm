class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
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