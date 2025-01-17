package top150

import TreeNode

/**
 * 129. Sum Root to Leaf Numbers
 * 현재까지 더한 값을 인자로 넘기고 다음 노드가 있다면 (현재까지 합 * 10)을 해준다.
 */
class SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode, currentSum: Int): Int {
        val sum = currentSum + node.`val`
        if (node.left == null && node.right == null) {
            return sum
        }

        val left = if (node.left != null) {
            dfs(node.left!!, sum * 10)
        } else {
            0
        }

        val right = if (node.right != null) {
            dfs(node.right!!, sum * 10)
        } else {
            0
        }

        return left + right
    }
}

fun main() {
    println(SumRootToLeafNumbers().sumNumbers(TreeNode.make(1,2,3)))
}