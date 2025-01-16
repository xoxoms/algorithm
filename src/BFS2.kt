class BFS2 {

    fun test(root: TreeNode?): Boolean {
        if (root == null) return false
        return recursive(root.left, root.right)
    }

    private fun recursive(l: TreeNode?, r: TreeNode?): Boolean {
        val lN = l == null
        val rN = r == null
        if (lN && rN) return true
        if (lN != rN) return false

        if (l?.`val` != r?.`val`) return false
        if (!recursive(l?.left, r?.right)) { return false }
        if (!recursive(l?.right, r?.left)) { return false }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = TreeNode(1)
            a.left = TreeNode(2)
            a.right = TreeNode(2)

            BFS2().test(a)
        }
    }
}