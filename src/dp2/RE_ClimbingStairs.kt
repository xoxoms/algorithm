package dp2

/**
 * 70. Climbing Stairs 재풀이
 * 41m
 * 오랜만에 했더니 방법을 까먹었다.. 41분이나 걸림
 * ==================
 * nums라는 어레이를 0으로 초기화 선언한다.
 * nums[1]과 nums[2]는 고정값으로 1과 2를 할당한다.
 * 3부터 n까지 순회한다.
 * nums[i]에는 nums[i - 1]와 nums[i - 2] 값의 합을 할당한다.
 * 이유는 1과 2씩 증가하므로 nums[i]가 될수있는 것은 i - 1번째와 i - 2번째 값의 경우의 수 합이기 때문이다.
 */
class RE_ClimbingStairs {

    fun climbStairs(n: Int): Int {
        val nums = IntArray(n + 2) { 0 }
        nums[1] = 1
        nums[2] = 2
        for (i in 3 .. n) {
            nums[i] = nums[i - 1] + nums[i - 2]
        }

        return nums[n]
    }
}

fun main() {
    println(RE_ClimbingStairs().climbStairs(4))
    println(RE_ClimbingStairs().climbStairs(3))
//    Test().climbStairs(2)
}