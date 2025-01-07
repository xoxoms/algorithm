package top150

/**
 * 380. Insert Delete GetRandom O(1)
 * O(1) 상수시간 탐색을 위해 해쉬 자료 구조를 사용한다.
 * insert, remove에는 문제없으나, getRandom에서 저장된 숫자중 하나를 반환해야한다.
 * 별도 list를 두어 추가로 관리한다.
 * hash 값과 List index를 연결하도록 hashMap으로 구현한다.
 *
 */
class RandomizedSet {
    private val map = mutableMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        val contains = map.contains(`val`)
        if (contains) return false
        map[`val`] = list.size
        list.add(`val`)

        return true
    }

    fun remove(`val`: Int): Boolean {
        val contains = map.contains(`val`)
        if (!contains) return false
        val index = map[`val`]!!
        list[index] = list.last()
        map[list[index]] = index
        list.removeLast()
        map.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        return list.random()
    }
}

fun main() {
    val randomizedSet = RandomizedSet()
    println(randomizedSet.insert(0))
    println(randomizedSet.insert(1))
    println(randomizedSet.remove(0))
    println(randomizedSet.insert(2))
    println(randomizedSet.remove(1))
    println(randomizedSet.getRandom())
//    print(1)
//    println(randomizedSet.remove(1))
//    print(1)
//    println(randomizedSet.insert(1))
//    print(1)
//    println(randomizedSet.remove(1))
//    print(1)
//    println(randomizedSet.insert(1))
//    print(2)
//    println(randomizedSet.insert(2))
//    print(3)
//    println(randomizedSet.insert(3))
//    print(3)
//    println(randomizedSet.remove(3))
//    print(3)
//    println(randomizedSet.insert(3))
//    print(0)
//    println(randomizedSet.insert(0))
//    print(5)
//    println(randomizedSet.insert(5))
//    print(5)
//    println(randomizedSet.insert(5))
//    print(5)
//    println(randomizedSet.insert(5))
}