package top150_2

import java.util.*

/**
 * 76. Minimum Window Substring !!
 * 3d 복잡도면에서 제대로 풀지못했다.
 * ==========================
 * map에 char 별 더미데이터로 초기화한다.
 * s를 char 순회하며 t에 해당하면 queue에 넣는다.
 * queue.size가 t.length와 같으면 result를 갱신한다.
 */
class MinimumWindowSubstring {

    private val map = mutableMapOf<Char, LinkedList<Int>>()
    private val queue = mutableSetOf<Int>()

    fun minWindow(s: String, t: String): String {
        var result = ""

        t.forEach {
            map.computeIfAbsent(it) { LinkedList<Int>() }.add(Int.MIN_VALUE)
        }

        for (i in 0 ..< s.length) {
            if (map.contains(s[i])) {
                put(s[i], i)
                if (queue.size == t.length) {
                    val min = queue.min()
                    val r = s.substring(min, i + 1)
                    if (result == "" || result.length > r.length) {
                        result = r
                    }

                    if (result.length == t.length) {
                        return result
                    }

                    queue.remove(min)
                }
            }
        }

        return result
    }

    private fun put(char: Char, index: Int) {
        val polled = map[char]!!.pollFirst()
        queue.remove(polled)
        map[char]!!.add(index)
        queue.add(index)
    }
}

fun main() {
    println(MinimumWindowSubstring().minWindow("acbbaca", "aba")) // baca
    println(MinimumWindowSubstring().minWindow("bdab", "ab"))
    println(MinimumWindowSubstring().minWindow("bbaa", "aba"))
    println(MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"))
}