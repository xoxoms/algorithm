package bfs

import java.util.*

/**
 * 490. The Maze
 * 시작 위치에서 이동할수있는 곳들을 큐에 넣는다.
 * 큐에넣으면서 방문처리한다.
 * 이미 방문된 것은 재처리하지 않는다.
 * 더이상 방문할 곳이 없다면 루프를 탈출하고 false 리턴한다.
 * 멈춘곳에 골이라면 true 리턴한다.
 */
class TheMaze {
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val visited = mutableSetOf<Pair<Int, Int>>()
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(start[0] to start[1])

        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            if (visited.contains(polled)) { continue } else { visited.add(polled) }
            if (polled.first == destination[0] && polled.second == destination[1]) { return true }

            var up: Int? = null
            for (i in polled.first - 1 downTo 0) {
                if (maze[i][polled.second] == 0) {
                    up = i
                } else {
                    break
                }
            }

            var down: Int? = null
            for (i in polled.first + 1 until maze.size) {
                if (maze[i][polled.second] == 0) {
                    down = i
                } else {
                    break
                }
            }
            var left: Int? = null
            for (i in polled.second - 1 downTo 0) {
                if (maze[polled.first][i] == 0) {
                    left = i
                } else {
                    break
                }
            }

            var right: Int? = null
            for (i in polled.second + 1 until maze[0].size) {
                if (maze[polled.first][i] == 0) {
                    right = i
                } else {
                    break
                }
            }

            up?.let { queue.add(up to polled.second) }
            down?.let { queue.add(down to polled.second) }
            left?.let { queue.add(polled.first to left) }
            right?.let { queue.add(polled.first to right) }
        }

        return false
    }
}

fun main() {
    println(
        TheMaze().hasPath(
            maze = arrayOf(
                intArrayOf(0, 0, 1, 0 ,0),
                intArrayOf(0, 0, 0, 0 ,0),
                intArrayOf(0, 0, 0, 1 ,0),
                intArrayOf(1, 1, 0, 1 ,1),
                intArrayOf(0, 0, 0, 0 ,0),
            ),
            start = intArrayOf(0, 4),
            destination = intArrayOf(4, 4),
        )
    )
}