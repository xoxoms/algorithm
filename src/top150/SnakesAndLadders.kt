package top150

import java.util.*

class SnakesAndLadders {
    /**
     * 909. Snakes and Ladders !!
     * 접근방법 다시해서 풀어야함.
     * 1,6
     * 6,12
     * 1,2
     * 2,15
     * 2,3
     * 현재 위치에서 접근가능한 사다리와 뱀, 최대위치를 배열로 만든다. (현재위치, 옮길위치)
     * 큐에 넣는다.
     * 옮겨진 값이 골이면 현재 움직인횟수를 리턴한다.
     * 5h30m
     */
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val goal = board.size * board.size
        val map = mutableMapOf<Int, MutableList<Int>>()
        val addNode = { from: Int, to: Int -> map.computeIfAbsent(from) { mutableListOf() }.add(to) }
        val snakesAndLadders = mutableMapOf<Int, Int>()

        var direction = -1
        var current = 1
        for (i in board.size - 1 downTo 0) {
            direction *= -1
            for (j in 0 ..< board.size) {
                val y = if (direction == 1) { j } else { board.size - 1 - j }
                addNode(current, current + 6)
                if (board[i][y] != -1) {
                    val dest = board[i][y]
                    addNode(current - 1, dest)
                    addNode(current - 2, dest)
                    addNode(current - 3, dest)
                    addNode(current - 4, dest)
                    addNode(current - 5, dest)
                    addNode(current - 6, dest)
                    snakesAndLadders[current] = dest
                }

                current++
            }
        }

        val visited = mutableSetOf<Int>()
        val queue = LinkedList<Int>()
        queue.add(1)

        var result = 0
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val poll = queue.poll()
                if (visited.contains(poll)) { continue }
                if (poll >= goal) {
                    return result
                }
                polls.add(poll)
            }

            if (polls.isEmpty()) { return -1 }
            for (poll in polls) {
                map[poll]?.forEach {
                    if (snakesAndLadders.containsKey(it)) {
                        queue.add(snakesAndLadders[it]!!)
                    } else {
                        queue.add(it)
                    }
                }

                visited.add(poll)
            }
            result++
        }

        return 1
    }
}

fun main() {

//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(1,1,-1),
//                intArrayOf(1,1,1),
//                intArrayOf(-1,1,1),
//            )
//        )
//    )

//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,-1,-1),
//                intArrayOf(-1,9,8),
//                intArrayOf(-1,8,9),
//            )
//        )
//    )
//
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,-1,-1,-1,-1,-1),
//                intArrayOf(-1,-1,-1,-1,-1,-1),
//                intArrayOf(-1,-1,-1,-1,-1,-1),
//                intArrayOf(-1,35,-1,-1,13,-1),
//                intArrayOf(-1,-1,-1,-1,-1,-1),
//                intArrayOf(-1,15,-1,-1,-1,-1),
//            )
//        )
//    )
//
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,-1,30,14,15,-1),
//                intArrayOf(23,9,-1,-1,-1,9),
//                intArrayOf(12,5,7,24,-1,30),
//                intArrayOf(10,-1,-1,-1,25,17),
//                intArrayOf(32,-1,28,-1,-1,32),
//                intArrayOf(-1,-1,23,-1,13,19),
//            )
//        )
//    )
//
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,4,-1),
//                intArrayOf(6,2,6),
//                intArrayOf(-1,3,-1),
//            )
//        )
//    )
//
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,1,2,-1),
//                intArrayOf(2,13,15,-1),
//                intArrayOf(-1,10,-1,-1),
//                intArrayOf(-1,6,2,8),
//            )
//        )
//    )
//
    println(
        SnakesAndLadders().snakesAndLadders(
            arrayOf(
                intArrayOf(-1,-1),
                intArrayOf(-1,3),
            )
        )
    )
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,-1,2,21,-1),
//                intArrayOf(16,-1,24,-1,4),
//                intArrayOf(2,3,-1,-1,-1),
//                intArrayOf(-1,11,23,18,-1),
//                intArrayOf(-1,-1,-1,23,-1),
//            )
//        )
//    )
}