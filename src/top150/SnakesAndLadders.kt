package top150

import java.util.*

/**
 * 909. Snakes and Ladders !!
 * 자고 일어나서 해결 완료!!!!
 * 뱀고 사다리만 기록해둔다.
 * 현재위치에서 +1~+6을 큐에 넣는다.
 * 만약 방문했거나, 뱀과 사다리라면 해당 뱀과 사다리 결과값을 사용한다.
 * ==========================
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
class SnakesAndLadders {

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val goal = board.size * board.size
        val visited = mutableSetOf<Int>()
        val snakesAndLadders = mutableMapOf<Int, Int>()
        var direction = -1
        var current = 1

        for (i in board.size - 1 downTo 0) {
            direction *= -1
            for (j in 0 until board.size) {
                val y = if (direction == 1) {
                    j
                } else {
                    board.size - 1 - j
                }

                if (board[i][y] != -1) {
                    snakesAndLadders[current] = board[i][y]
                }
                current++
            }
        }

        var count = 0
        val queue = LinkedList<Int>()
        queue.add(1)
        visited.add(1)

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                polls.add(polled)
            }
            if (polls.isEmpty()) { break }
            count++

            for (poll in polls) {
                for (i in 1 .. 6) {
                    val next = poll + i

                    val value = if (snakesAndLadders[next] == null) {
                        next
                    } else {
                        snakesAndLadders[next]!!
                    }

                    if (visited.contains(value)) { continue }
                    visited.add(value)
                    queue.add(value)
                    if (value >= goal) {
                        return count
                    }
                }
            }
        }

        return -1
    }
}

fun main() {

    println(
        SnakesAndLadders().snakesAndLadders(
            arrayOf(
                intArrayOf(-1,-1,-1,46,47,-1,-1,-1),
                intArrayOf(51,-1,-1,63,-1,31,21,-1),
                intArrayOf(-1,-1,26,-1,-1,38,-1,-1),
                intArrayOf(-1,-1,11,-1,14,23,56,57),
                intArrayOf(11,-1,-1,-1,49,36,-1,48),
                intArrayOf(-1,-1,-1,33,56,-1,57,21),
                intArrayOf(-1,-1,-1,-1,-1,-1,2,-1),
                intArrayOf(-1,-1,-1,8,3,-1,6,56),
            )
        )
    )

    println(
        SnakesAndLadders().snakesAndLadders(
            arrayOf(
                intArrayOf(1,1,-1),
                intArrayOf(1,1,1),
                intArrayOf(-1,1,1),
            )
        )
    )

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
//    println(
//        SnakesAndLadders().snakesAndLadders(
//            arrayOf(
//                intArrayOf(-1,-1),
//                intArrayOf(-1,3),
//            )
//        )
//    )
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