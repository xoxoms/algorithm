package top150

import TreeNode

/**
 * 100. Same Tree
 */
class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return p == null && q == null || (
            p?.`val` == q?.`val` &&
            isSameTree(p?.left, q?.left) &&
            isSameTree(p?.right, q?.right)
        )
    }
}

fun main() {
    val root1 = TreeNode.make(1,2,3)
    val root2 = TreeNode.make(1,2,3)
    println(SameTree().isSameTree(root1, root2))
}