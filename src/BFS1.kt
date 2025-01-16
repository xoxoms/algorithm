class BFS1 {

    fun test(p: TreeNode?, q: TreeNode?): Boolean {
        if ((p == null) != (q == null)) return false

        if (p == null) {
            return true
        }
        if (p.`val` != q!!.`val`) {
            return false
        }
        if (!test(p.left, q.left)) {
            return false
        }

        if (!test(p.right, q.right)) {
            return false
        }

        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = TreeNode(1)
            a.left = TreeNode(2)
            a.right = TreeNode(3)
            val b = TreeNode(1)
            b.left = TreeNode(2)
            b.right = TreeNode(3)

            BFS1().test(a, b)
        }
    }
}