package leetcode75

/**
 * 841. Keys and Rooms !!
 * 잘못된 방법으로 해결하려다보니 디버깅에 너무 오래걸렸다.
 * 정상적인 방법으로 복습필요.
 */
class KeysAndRoom {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size) { false }
        fun dfs(idx: Int) {
            if (visited[idx]) { return }
            visited[idx] = true
            rooms[idx].forEach { dfs(it) }
        }

        dfs(0)
        return visited.all { it }
    }

    fun canVisitAllRooms2(rooms: List<List<Int>>): Boolean {
        val ins = mutableMapOf<Int, MutableSet<Int>>()
        val outs = mutableMapOf<Int, MutableSet<Int>>()

        for (i in 0 ..< rooms.size) {
            ins.computeIfAbsent(i) { mutableSetOf() }
            outs[i] = mutableSetOf<Int>()
            if (rooms[i].isNotEmpty()) {
                for (j in 0 ..< rooms[i].size) {
                    outs[i]!!.add(rooms[i][j])
                    ins.computeIfAbsent(rooms[i][j]) { mutableSetOf<Int>() }
                        .add(i)
                }
            }
        }

        ins[0] = mutableSetOf<Int>()
        if (ins.any { it.key != 0 && it.value.isEmpty() }) { return false }

        while (true) {
            val targetKey = ins
                .entries
                .firstOrNull { it.value.isEmpty() }?.key ?: break
            outs[targetKey]!!
                .forEach {
                    if (ins[it]?.isNotEmpty() == true) {
                        ins[it] = mutableSetOf()
                    }
                }
            ins.remove(targetKey)
        }

        return ins.isEmpty()
    }
}

fun main() {
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(4),listOf(0),listOf(1),listOf(2),listOf(3))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1), listOf(), listOf(0, 3), listOf(1))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1, 2), listOf(2, 1), listOf(1))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1), listOf(1))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1), listOf(1))))
    println(KeysAndRoom().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
}