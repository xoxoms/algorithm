package top150_2

import TreeNode
import java.util.*

/**
 * 114. Flatten Binary Tree to Linked List
 * 1h 15m
 * 좀더 익숙해지면 쉽게 풀거같다.
 * 오..!! 무려 1회차때 못풀었던 문제였다. 컷!!
 * ==================================
 * left 가 없을때까지 파고 들어간다.
 * 각 원소에 right가 있으면 큐에 넣는다.
 * left가 없으면 queue에서 꺼내서 다시 루핑한다.
 * 위에 반복한다.
 */
class FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) { return }
        recursive(root)
    }

    val queue = LinkedList<TreeNode>()
    private fun recursive(node: TreeNode): TreeNode {
        node.right?.let { queue.add(it) }
        val target = if (node.left != null) {
            node.right = recursive(node.left!!)
            node.left = null

            node.right!!
        } else {
            node
        }

        if (queue.isNotEmpty()) {
            target.right = recursive(queue.pollLast())
        }

        return node
    }
}

fun main() {
    FlattenBinaryTreeToLinkedList().flatten(TreeNode.make(1,2,5,3,4,null,6))
}