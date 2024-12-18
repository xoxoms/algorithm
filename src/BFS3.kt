class BFS3 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun test(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf(root.`val`))
        recursive(root, 1, result)
        return result
    }
    private fun recursive(root: TreeNode?, level: Int, result: MutableList<MutableList<Int>>) {
        if (root == null) { return }
        var newLevel = level
        if (root.left?.`val` != null) {
            if (result.size <= level) { result.add(mutableListOf()) }
            newLevel = level+1
            result[level].add(root.left!!.`val`)
        }
        if (root.right?.`val` != null) {
            if (result.size <= level) { result.add(mutableListOf()) }
            newLevel = level+1
            result[level].add(root.right!!.`val`)
        }
        recursive(root.left, newLevel, result)
        recursive(root.right, newLevel, result)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = TreeNode(1)
            a.left = TreeNode(2)
            a.right = TreeNode(2)

            BFS3().test(a)
        }
    }
}