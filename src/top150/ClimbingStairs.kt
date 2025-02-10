package top150

/**
 * 70. Climbing Stairs !!
 * 40m
 * easy 난이도이지만 고민을 많이했다.
 * 시뮬레이션 돌려보니 각이보임.
 * 시뮬레이션 안해봤으면 풀지못했을것같다. 이런 유형은 암기해야하는 항목일듯.
 * ========================
 * 1또는 2씩 증가가능하기때문에,
 * 현재 값 - 1 + 현재값 - 2의 경우의 수를 합치면 된다.
 * 예를들어 3이라면,
 * 1에서 2를 더한 값이 추가로 가능하고
 * 2에서 1을 더한 값이 추가로 가능하다.
 * 1에서 1+1을한 값은 이미 2에서 사용됐으므로 중복이다.
 */
class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        var prev = 1
        var result = 1

        for (i in 2 .. n) {
            val temp = prev
            prev = result
            result += temp
        }

        return result
    }
}

fun main() {
    println(ClimbingStairs().climbStairs(4))
}