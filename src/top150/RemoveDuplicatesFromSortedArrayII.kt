package top150

/**
 * 80. Remove Duplicates from Sorted ArrayII
 * O(N). 30m. 비효율적으로 짠듯..
 * i,j 투포인터로 해결.
 * 입력하려는 i의 -2번째가 j와 같으면 제거
 * i가 1이면 삽입
 * i가 2이고 i-2인 0과 j가 같으면 패스. j++
 * i가 2이고 i-2인 0과 j가 다르면 삽입. i++, j++
 * i가 3이고 i-2인 1과 j가 같으면 패스. i++, j++
 * i가 3이고 i-2인 1과 j가 다르면 삽입. i++, j++
 * i가 4이고 i-2인 2와 j가 같으면 패스. j++
 */
class RemoveDuplicatesFromSortedArrayII {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 3) return nums.size
        var i = 2
        var j = 2
        var count = 2

        while (j < nums.size) {
            if (nums[i - 1] != nums[j] || (nums[i - 1] != nums[i - 2])) {
                nums[i++] = nums[j]
                count++
            }
            j++
        }

        return count
    }
}

fun main() {
    println(
        RemoveDuplicatesFromSortedArrayII().removeDuplicates(
            intArrayOf(0,0,1,1,1,2,2,3,3,4)
        )
    )
}