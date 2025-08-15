package top150_2

/**
 * 77. Combinations
 * 재귀로 해결했다. 20m
 * 어려울수있었으나 방향성을 잘잡은듯, 그러나 해법의 시간복잡도가 좋진않다.
 * =======================
 * 1 .. n까지 중복없는 조합을 반환하는 것이므로, 각 루핑 대상 원소의 이전 값들은 체크하지 않아도 된다.
 * idx + 1 처리했다.
 */
class Combinations {

    private val result = mutableListOf<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        recursive(n, k, 1, 1, mutableListOf<Int>())
        return result
    }

    private fun recursive(n: Int, k: Int, i: Int, j: Int, target: MutableList<Int>) {

        if (target.size == k) {
            result.add(target.map { it })
            return
        }

        for (idx in i .. k) {
            for (jdx in j .. n) {
                target.add(jdx)
                recursive(n, k, idx + 1, jdx + 1, target)
                target.removeLast()
            }
        }
    }
}