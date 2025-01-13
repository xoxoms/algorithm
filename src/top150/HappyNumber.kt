package top150

class HappyNumber {

    /**
     * 202. Happy Number
     * 이상한 문제같음.....................
     * 타겟을 정한다.
     * 타겟을 1자씩 끊고 제곱한 값을 맵에 넣는다.
     * 타겟에 합을 대입하고 위를 반복한다.
     * 합이 1이면 성공응답한다.
     *
     */
    fun isHappy(n: Int): Boolean {
        var target = n
        val map = mutableMapOf<Int, Int>()
        val visited = mutableSetOf<Int>()

        while (target != 1) {
            if (visited.contains(target)) {
                return false
            } else {
                visited.add(target)
            }
            var sum = 0
            for (c in target.toString()) {
                val num = c.toString().toInt()
                map[num] = num * num
                sum += map[num]!!
            }

            if (target == sum) {
                return false
            }
            target = sum
        }

        return true
    }
}

fun main() {
    println(HappyNumber().isHappy(19))
    println(HappyNumber().isHappy(3))
}