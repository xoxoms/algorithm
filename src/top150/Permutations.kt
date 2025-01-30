package top150

/**
 * 46. Permutations
 * nums 값을 갖는 inputs라는 set을 만든다.
 * 이전까지의 값을 갖는 prev라는 배열을 만든다.
 * dp 함수를 호출한다.
 * inputs가 비었다면 다르면 result에 지금까지의 prev를 넣는다..
 * inputs가 비지않았다면 dp 처리한다.
 */
class Permutations {
    private val result = mutableListOf<MutableList<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        val inputs = mutableSetOf<Int>()
        for (element in nums) {
            inputs.add(element)
        }

        dp(nums, inputs, mutableListOf())
        return result
    }

    private fun dp(nums: IntArray, inputs: MutableSet<Int>, prev: MutableList<Int>) {
        if (inputs.isEmpty()) {
            result.add(ArrayList(prev))
        } else {
            for (current in nums) {
                if (inputs.contains(current)) {
                    inputs.remove(current)
                    prev.add(current)
                    dp(nums, inputs, prev)
                    inputs.add(current)
                    prev.removeLast()
                }
            }
        }
    }
}

fun main() {
    println(Permutations().permute(intArrayOf(1,2,3)))
}