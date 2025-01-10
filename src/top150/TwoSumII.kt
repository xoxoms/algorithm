package top150

/**
 * 167. Two Sum II - Input Array Is Sorted
 * 좌항과 우항의 인덱스를 둔다.
 * 두 인덱스의 합을 구한다.
 * 타겟보다 크면 우항을 --
 * 타겟보다 작으면 좌항을 ++
 * 두값을 타겟과 비교한다.
 * 반복한다.
 */
class TwoSumII {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--
            } else if (numbers[i] + numbers[j] < target) {
                i++
            } else if (numbers[i] + numbers[j] == target) {
                return intArrayOf(i + 1, j + 1)
            }
        }

        return intArrayOf(i, j + 1)
    }
}

fun main() {
    TwoSumII().twoSum(intArrayOf(0,0,3,4), 0).forEach { print("$it ") }
    println()
    TwoSumII().twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { print("$it ") }
    println()
}