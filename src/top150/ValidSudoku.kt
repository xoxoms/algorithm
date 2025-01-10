package top150

import java.util.*

/**
 * 36. Valid Sudoku
 * 수도쿠를 만드는줄알았다.......
 * 단순 유효성검사
 */
class ValidSudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val visited = mutableSetOf<Pair<Int, Int>>()

        for (i in 0 .. 8) {
            val set1 = mutableSetOf<Int>()
            val set2 = mutableSetOf<Int>()

            for (j in 0 .. 8) {
                if (board[i][j] != '.') {
                    if (set1.contains(board[i][j].toString().toInt())) {
                        return false
                    } else {
                        set1.add(board[i][j].toString().toInt())
                    }
                }

                if (board[j][i] != '.') {
                    if (set2.contains(board[j][i].toString().toInt())) {
                        return false
                    } else {
                        set2.add(board[j][i].toString().toInt())
                    }
                }

                val iRegion = if (i == 0) 0 else i / 3
                val jRegion = if (j == 0) 0 else j / 3
                if (visited.contains(Pair(iRegion, jRegion))) {
                    continue
                } else {
                    visited.add(Pair(iRegion, jRegion))
                }

                val iStart = iRegion * 3
                val iEnd = iStart + 2
                val jStart = jRegion * 3
                val jEnd = jStart + 2

                val set3 = mutableSetOf<Int>()
                for (i2 in iStart .. iEnd) {
                    for (j2 in jStart .. jEnd) {
                        if (board[i2][j2] == '.') continue
                        if (set3.contains(board[i2][j2].toString().toInt())) {
                            return false
                        } else {
                            set3.add(board[i2][j2].toString().toInt())
                        }
                    }
                }
            }
        }

        return true
    }

    fun isValidSudoku2(board: Array<CharArray>): Boolean {
        if (board.all { it.all { item -> item == '.' } }) { return true }

        val getPossibleNumbers = { map: MutableList<MutableMap<Int, Int>>, iIdx: Int, jIdx: Int ->
            val iRegion = if (iIdx == 0) 0 else iIdx / 3
            val jRegion = if (jIdx == 0) 0 else jIdx / 3
            val iStart = iRegion * 3
            val iEnd = iStart + 2
            val jStart = jRegion * 3
            val jEnd = jStart + 2

            val targets = mutableSetOf(1,2,3,4,5,6,7,8,9)
            for (i in iStart .. iEnd) {
                for (j in jStart .. jEnd) {
                    targets.remove(map[i][j])
                }
            }

            for (i in 0 until 9) {
                if (map[iIdx].containsKey(i)) {
                    targets.remove(map[iIdx][i])
                }
                if (map[i].containsKey(jIdx)) {
                    targets.remove(map[i][jIdx])
                }
            }

            targets
        }

        val newMap = mutableListOf<MutableMap<Int, Int>>()
        for (i in 0 until board.size) {
            val row = mutableMapOf<Int, Int>()
            newMap.add(row)
            for (j in 0 until board[0].size) {
                if (board[i][j] == '.') { continue }
                row[j] = board[i][j].toString().toInt()
            }
        }

        val queue = LinkedList<MutableList<MutableMap<Int, Int>>>()
        queue.add(newMap)
        var updated = false
        while (queue.isNotEmpty()) {
            val polled = queue.poll()
            updated = false
            for (i in 0 until 9) {
                for (j in 0 until 9) {
                    if (polled[i][j] == null) {
                        val possibleNumbers = getPossibleNumbers(polled, i, j)
                        if (possibleNumbers.size == 1) {
                            polled[i][j] = possibleNumbers.first()
                            updated = true
                        }
                    }
                }
            }

            if (updated) {
                if (polled.sumOf { it.size } == 81) {
                    break
                } else {
                    queue.add(polled)
                }
            } else {
                return false
            }

        }

        return updated
    }
}

fun main() {
    println(ValidSudoku().isValidSudoku(
            arrayOf(
                charArrayOf('5','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9'),
            )
        )
    )
}