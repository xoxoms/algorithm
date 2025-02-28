package leetcode75

import java.util.LinkedList

/**
 * 649. Dota2 Senate !!
 * 문제 파악하는데 시간이 좀 걸렸고
 * 복잡도는 크게 떨어지지 않으나, 구현이 요란하다.
 */
class Dota2Senate {

    fun predictPartyVictory(senate: String): String {
        val queue = LinkedList<Char>()
        for (i in 0 ..< senate.length) {
            queue.add(senate[i])
        }

        while (true) {
            var prev: Char? = null
            var count = 0
            var doReturn = true

            val polled = mutableListOf<Char>()
            while (queue.isNotEmpty()) {
                val current = queue.poll()
                if (prev == null) { prev = current }
                if (current == prev) {
                    count++
                    polled.add(current)
                } else if (--count == 0) {
                    prev = null
                    doReturn = false
                }
            }

            if (doReturn) {
                return if (prev == 'D') {
                    "Dire"
                } else {
                    "Radiant"
                }
            }


            for (i in 0 ..< polled.size) {
                if (count > 0) {
                    if (polled[i] != prev) {
                        count--
                        continue
                    }
                }
                queue.add(polled[i])
            }
        }
    }
}

fun main() {
    println(Dota2Senate().predictPartyVictory("DDRRRR"))
    println(Dota2Senate().predictPartyVictory("RD"))
}