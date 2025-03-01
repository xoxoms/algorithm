package leetcode75

import java.util.LinkedList

/**
 * 1926. Nearest Exit from Entrance in Maze
 * 기본적인 BFS 문제
 */
class NearestExitFromEntranceInMaze {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val ent = Pair(entrance[0], entrance[1])
        val queue = LinkedList<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        queue.add(ent)
        var count = 0
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<Pair<Int, Int>>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (visited.contains(polled)) {
                    continue
                } else {
                    visited.add(polled)
                    polls.add(polled)
                }

                if (polled != ent && (polled.first == 0 || polled.second == 0 || polled.first == maze.size - 1 || polled.second == maze[0].size - 1)) {
                    return count
                }
            }

            for (i in 0 ..< polls.size) {
                if (polls[i].first < maze.size - 1 && maze[polls[i].first + 1][polls[i].second] == '.') {
                    queue.add(Pair(polls[i].first + 1, polls[i].second))
                }
                if (polls[i].first > 0 && maze[polls[i].first - 1][polls[i].second] == '.') {
                    queue.add(Pair(polls[i].first - 1, polls[i].second))
                }
                if (polls[i].second < maze[0].size - 1 && maze[polls[i].first][polls[i].second + 1] == '.') {
                    queue.add(Pair(polls[i].first, polls[i].second + 1))
                }
                if (polls[i].second > 0 && maze[polls[i].first][polls[i].second - 1] == '.') {
                    queue.add(Pair(polls[i].first, polls[i].second - 1))
                }
            }
            count++
        }

        return -1
    }
}

fun main() {
    println(
        NearestExitFromEntranceInMaze().nearestExit(
            arrayOf(
                charArrayOf('+','+','.','+'),
                charArrayOf('.','.','.','+'),
                charArrayOf('+','+','+','.'),
            ),
            intArrayOf(1, 2)
        )
    )
}