package top150

/**
 * 27. Remove Element
 * O(N). 30m
 * 투포인터로 해결하자
 * i번째 원소가 `val`이라면 j번째로 채운다.
 * j번째는 -1로 변경한다.
 * i++, j-- 처리한다.
 * i번째가 -1이거나 마지막이면 제거된 갯수를 리턴한다.
 */
class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        var j = nums.size - 1

        var count = 0
        while (true) {
            if (nums[i] == `val`) {
                nums[i] = nums[j]
                nums[j--] = -1
                count++
            } else {
                i++
            }

            if (i == nums.size || nums[i] == -1) {
                return nums.size - count
            }
        }
    }
}

fun main() {
    println(
        RemoveElement().removeElement(
            nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2),
            `val` = 2,
        )
    )
}