package top150_2

import TreeNode

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal !!
 * 3d
 * 어렵다.......그렇지만 해결했다.
 * =============================
 * index맵과 TreeNode 맵을 초기화한다.
 * postorder는 루트를 마지막으로 순회한다.
 * inorder는 루트를 중간에 순회한다.
 *
 * postorder의 각 원소는 -1번째 원소의 right일 수 있다.
 * inorder 원소와 비교하여 isRight인지 확인하여, 맞다면 right에 할당한다
 * 틀리다면, 해당 원소를 특정원소의 left로 할당하는 로직을 수행한다.
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private val inorderMap = mutableMapOf<Int, Int>()
    private val postorderMap = mutableMapOf<Int, Int>()
    private val map = mutableMapOf<Int, TreeNode>()

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        for (i in 0 ..< inorder.size) {
            inorderMap[inorder[i]] = i
            postorderMap[postorder[i]] = i
            map[inorder[i]] = TreeNode(inorder[i])
        }

        val result = postorder.lastOrNull()?.let { map[it] }
        right(inorder, postorder, postorder.size - 1)

        return result
    }

    private fun right(inorder: IntArray, postorder: IntArray, index: Int): TreeNode {
        val root = map[postorder[index]]!!

        if (index > 0) {
            val right = right(inorder, postorder, index - 1)
            if (isRight(root, right)) {
                root.right = right
            } else {
                getLeftRoot(inorder, postorder, right.`val`)?.left = right
            }
        }

        return root
    }

    private fun isRight(rootValue: TreeNode, rightValue: TreeNode): Boolean {
        return inorderMap[rootValue.`val`]!! < inorderMap[rightValue.`val`]!!
    }

    private fun getLeftRoot(inorder: IntArray, postorder: IntArray, leftValue: Int): TreeNode? {
        for (i in inorderMap[leftValue]!! + 1 ..< inorderMap.size) {
            for (j in postorderMap[leftValue]!! + 1 ..< postorderMap.size) {
                if (inorder[i] == postorder[j]) {
                    return map[inorder[i]]
                }
            }
        }

        return null
    }
}

fun main() {
    val result = ConstructBinaryTreeFromInorderAndPostorderTraversal()
        .buildTree(
//            intArrayOf(9,3,15,20,7),
//            intArrayOf(9,15,7,20,3),
//            intArrayOf(2,3,1),
//            intArrayOf(3,2,1),
            intArrayOf(1,3,4,6,7,8,10,13,14),
            intArrayOf(1,4,7,6,3,13,14,10,8),
        )

    println(result)
}