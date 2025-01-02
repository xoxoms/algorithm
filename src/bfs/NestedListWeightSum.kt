package bfs

import java.util.*
import kotlin.collections.ArrayList

class NestedInteger(
    private var value: Int? = null,
    private var nestedIntegers: MutableList<NestedInteger>?,
) {
    // Constructor initializes an empty nested list.
    // constructor()
    // Constructor initializes a single integer.
    // constructor(value: Int)
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean {
        return value != null
    }
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? {
        return value
    }
    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {
        this.value = value
    }
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {
        if (this.nestedIntegers == null) {
            this.nestedIntegers = ArrayList()
        }

        this.nestedIntegers!!.add(ni)
    }
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? {
        return this.nestedIntegers
    }
}

/**
 * 339. Nested List Weight Sum
 * 여러가지 방식이 있겠으나, queue.addFirst로 처리해봄.
 * 전달 받은 NestedInteger를 큐에 넣는다.
 * 해당 원소가 singleInteger라면 값을 기록한다
 * 해당 원소가 배열이면 nl의 내부 원소들을 넣고, round++ 처리한다.
 * 모든 원소 순회를 마치면 round-- 처리한다.
 */
class NestedListWeightSum {
    fun depthSum(nestedList: List<NestedInteger>): Int {
        val result = mutableListOf<Int>()
        val queue = LinkedList<NestedInteger>()
        queue.addAll(nestedList)
        var round = 1

        while (queue.isNotEmpty()) {
            val polls = mutableListOf<NestedInteger>()
            while (queue.isNotEmpty()) {
                val polled = queue.poll()
                if (polled.isInteger()) {
                    result.add(polled.getInteger()!! * round)
                } else {
                    polled.getList()!!.forEach { polls.add(it) }
                }
            }

            for (polled in polls) {
                queue.addFirst(polled)
            }

            if (polls.size > 0) {
                round++
            } else {
                round--
            }
        }

        return result.sum()
    }
}

fun main() {
    println(
        NestedListWeightSum().depthSum(
            listOf(
                NestedInteger(
                    value = null,
                    nestedIntegers = mutableListOf(
                        NestedInteger(value = 1, nestedIntegers = mutableListOf()),
                        NestedInteger(value = 1, nestedIntegers = mutableListOf()),
                    )
                ),
                NestedInteger(
                    value = 2,
                    nestedIntegers = mutableListOf(),
                ),
                NestedInteger(
                    value = null,
                    nestedIntegers = mutableListOf(
                        NestedInteger(value = 1, nestedIntegers = mutableListOf()),
                        NestedInteger(value = 1, nestedIntegers = mutableListOf()),
                    )
                ),
            )
        )
    )
}