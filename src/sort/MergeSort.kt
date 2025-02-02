package sort

/**
 * SortList를 해결하기 위해서 병합정렬 먼저 선행 학습이 필요했다.
 */
class MergeSort {

    fun sort(list: List<Int>): List<Int> {
        return sort(list, 0, list.size - 1)
    }

    private fun sort(list: List<Int>, l: Int, r: Int): List<Int> {
        if (l == r) { return listOf(list[l]) }

        val mid = getMid(l, r)
        val left = sort(list, l, mid - 1)
        val right = sort(list, mid, r)

        val result = mutableListOf<Int>()
        var cursorL = 0
        var cursorR = 0
        while (result.size != left.size + right.size) {
            if (cursorL == left.size) {
                result.add(right[cursorR++])
            } else if (cursorR == right.size) {
                result.add(left[cursorL++])
            } else {
                if (left[cursorL] > right[cursorR]) {
                    result.add(right[cursorR++])
                } else {
                    result.add(left[cursorL++])
                }
            }
        }

        return result
    }

    private fun getMid(l: Int, r: Int): Int {
        var left = l
        var right = l

        while (right < r) {
            left += 1
            right += 2
        }

        return left
    }
}

fun main() {
    println(MergeSort().sort(mutableListOf(5, 4, 1, 9, 3, 7, 2, 6, 8)))
}