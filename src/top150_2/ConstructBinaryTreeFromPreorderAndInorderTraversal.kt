package top150_2

import TreeNode
import java.util.LinkedList

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 이틀걸렸다. 한 10시간 푼듯.
 * 해결 방법도 복잡도면에서 좋지않음
 * ============================
 * preorder를 순회한다.
 * inorder와 비교한다.
 * 값이 다르면 left에 채워준다.
 * 값이 같으면 right에 채울값이다.
 * right에 할당 해야하는데, 어떤 노드의 right에 할당할지 구해야한다.
 * 만약 preorder와 inorder가 같고 inorder의 nextvalue가 한번도 방문하지 않은 값이면
 * 현재 마지막 노드의 오른쪽에 할당한다.
 * 아니면, 즉 inorder의 nextValue가 방문한 값이면 while문을 반복하면서 dequeue한다.
 * right에 할당한 후 플래그를 업데이트한다.
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) { return null }
        if (preorder.size == 1) { return TreeNode(preorder.first()) }

        val map = preorder.associateBy({ it }) { TreeNode(it) }

        val visited = mutableSetOf<Int>()
        var j = 0

        var direction = preorder.first() != inorder.first()
        val queue = LinkedList<Int>()
        for (i in 0 ..< preorder.size) {
            val current = preorder[i]
            visited.add(current)
            if (direction) {
                queue.lastOrNull()?.let { map[it]!!.left = map[current] }
            } else {
                queue.pollLast()?.let { map[it]!!.right = map[current] }
                direction = true
            }
            queue.add(current)

            if (current == inorder[j]) {
                while (j + 1 < inorder.size && visited.contains(inorder[++j])) {
                    queue.pollLast()
                }

                direction = false
            }
        }

        return map[preorder.first()]
    }
}

fun main() {
    ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(
            intArrayOf(3,2,1,4),
            intArrayOf(1,2,3,4),
        )
    ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(
            intArrayOf(1,2,3),
            intArrayOf(2,3,1),
        )
    ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(
            intArrayOf(1,2),
            intArrayOf(1,2),
        )
    ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(
            intArrayOf(8,3,1,6,4,7,10,14,13),
            intArrayOf(1,3,4,6,7,8,10,13,14),
        )
    ConstructBinaryTreeFromPreorderAndInorderTraversal()
        .buildTree(
            intArrayOf(3,9,20,15,7),
            intArrayOf(9,3,15,20,7),
        )
}