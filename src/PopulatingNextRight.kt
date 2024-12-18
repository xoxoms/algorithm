import java.util.LinkedList

class PopulatingNextRight {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun test(root: Node?): Node? {
        val queue = LinkedList<Node>()
        root?.let { queue.add(it) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            var prev: Node? = null
            for (i in 0 until size) {
                val polled = queue.pollFirst()
                if (prev != null) { prev.next = polled }
                prev = polled

                polled?.left?.let { queue.add(it) }
                polled?.right?.let { queue.add(it) }
            }
        }

        return root
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val n7 = Node(7)
            val n15 = Node(15)
            val n20 = Node(20)
            val n9 = Node(9)
            val n3 = Node(3)
            n3.left = n9
            n3.right = n20
            n20.left = n15
            n20.right = n7

            println(PopulatingNextRight().test(n3))
        }
    }
}