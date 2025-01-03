package bfs

import TreeNode
import java.util.*

/**
 * 449. Serialize and Deserialize BST
 */
class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val queue = LinkedList<TreeNode?>()
        queue.add(root)

        val result = mutableListOf<String>()
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            result.add(polled?.`val`?.toString() ?: "null")
            polled ?: continue
            polled.left.let { queue.add(it) }
            polled.right.let { queue.add(it) }
        }

        return result.joinToString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null

        val queue = LinkedList<TreeNode?>()
        val split = data.split(",")
        val result = TreeNode(split[0].toInt())
        queue.add(result)

        for (i in 1..< split.size) {
            val value = split[i].trim()
            val newNode = if (value == "null") {
                null
            } else {
                TreeNode(value.toInt())
            }

            val polled = queue.poll()!!

            if (polled.left == null) {
                polled.left = newNode ?: TreeNode(-1)
                queue.addFirst(polled)
            } else {
                if (polled.left!!.`val` == -1) {
                    polled.left = null
                }

                polled.right = newNode
                polled.left?.let { queue.add(it) }
                polled.right?.let { queue.add(it) }
            }
        }

        return result
    }
}

fun main() {
    println(
        SerializeAndDeserializeBST().serialize(SerializeAndDeserializeBST().deserialize("1,null,2"))
    )
    println(
        SerializeAndDeserializeBST().serialize(SerializeAndDeserializeBST().deserialize("1,2,3,4,5,6,7,8,9,10"))
    )
}