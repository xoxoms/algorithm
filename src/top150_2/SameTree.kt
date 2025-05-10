package top150_2

import TreeNode

/**
 * 100. Same Tree
 * 재귀로 풀었다.
 */
class SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if ((p == null) != (q == null)) { return false }
        if (p == null && q == null) { return true }

        if (isSameTree(p?.left, q?.left) == false) {
            return false
        }
        if (isSameTree(p?.right, q?.right) == false) {
            return false
        }

        return p?.`val` == q?.`val`
    }
}