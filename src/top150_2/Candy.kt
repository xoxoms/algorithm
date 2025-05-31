package top150_2

/**
 * 135. Candy !!
 * hard라고 너무 어렵게 생각했는데 풀어보니 답안까지는 어렵지않았다.
 * 효율적인 해법이 아니라서 문제!
 * 2h
 * ================
 * 페이즈1
 * i를 size만큼 루핑한다.
 * i 번째와 앞뒤 값을 비교한다.
 * 앞뒤 값보다 i 값이 크면 의존 리스트에 추가한다.
 *
 * 페이즈2
 * 각 i번째 의존 리스트를 순회한다.
 * 의존 리스트 item을 따라가면서 depth를 구한다.
 * 의존 리스트 depth 값들중 가장 큰 값을 리턴한다.
 * 방문처리한다.
 *
 * depth  모두 더한 값을 결과로 반환한다.
 */
class Candy {
    private val visited = mutableMapOf<Int, Int>()

    fun candy(ratings: IntArray): Int {
        val candies = Array<MutableList<Int>>(ratings.size) { mutableListOf() }

        for (i in 0 ..< ratings.size) {
            if (i + 1 < ratings.size && ratings[i + 1] < ratings[i]) {
                 candies[i].add(i + 1)
            }

            if (i - 1 > -1 && ratings[i - 1] < ratings[i]) {
                 candies[i].add(i - 1)
            }
        }

        var r = 0
        for (i in 0 ..< candies.size) {
            r += depth(i, candies)
        }

        return r
    }

    private fun depth(idx: Int, l: Array<MutableList<Int>>): Int {
        if (visited.contains(idx)) {
            return visited[idx]!!
        }

        return if (l[idx].isEmpty()) {
            1
        } else {
            val result = l[idx].maxOf { depth(it, l) + 1 }
            visited[idx] = result
            result
        }
    }

    private fun depth2(current: Int, idx: Int, l: Array<MutableList<Int>>): Int {
        if (visited.contains(idx)) {
            return current + visited[idx]!!
        }

        return if (l[idx].isEmpty()) {
            current
        } else {
            val result = l[idx].maxOf { depth2(current + 1, it, l) }
            visited[idx] = result - current
            result
        }
    }
}

fun main() {
    println(Candy().candy(intArrayOf(1,0,2)))
    println(Candy().candy(intArrayOf(1,3,2,2,1)))
}