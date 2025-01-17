package top150

import TreeNode

/**
 * 226. Invert Binary Tree
 * 어렵게 생각했는데, 쉽다.
 * dfs로 왼쪽과 오른쪽 스왑하면 재귀처리되어 결국 전부 역순으로 바뀜
 */
class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        return dfs(root)
    }

    private fun dfs(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val temp = root.left
        root.left = root.right
        root.right = temp

        dfs(root.left)
        dfs(root.right)
        return root
    }

    private fun recursive(nodes: List<TreeNode?>): List<TreeNode?> {
        if (nodes.all { it == null }) {
            return emptyList()
        }

        val targets = mutableListOf<TreeNode?>()
        nodes.forEach {
            targets.add(it?.left)
            targets.add(it?.right)
        }

        val children = recursive(targets)
        var i = 0

        return nodes
            .reversed()
            .map {
                val newNode = it?.`val`?.let { value -> TreeNode(value) }
                if (children.isNotEmpty()) {
                    val newLeft = children[i++]
                    val newRight = children[i++]

                    newNode?.let {
                        newNode.left = newLeft
                        newNode.right = newRight
                    }
                }
                newNode
            }
    }
}

fun main() {
    val result1 = InvertBinaryTree().invertTree(TreeNode.make(2, 3, null, 1, null, null, null))
    val result2 = InvertBinaryTree().invertTree(TreeNode.make(4,2,7,1,3,6,9))
    val result3 = InvertBinaryTree().invertTree(TreeNode.make(4,2,7,1,3,6,9))
}