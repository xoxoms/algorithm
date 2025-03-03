package top150_2

/**
 * 189. Rotate Array
 * k번 로테이트했을때 앞으로 이동해야하는 것들은 back에 채워둔다.
 * back을 nums에 옮긴다.
 */
class RotateArray {

    fun rotate(nums: IntArray, k: Int): Unit {
        val newK = k % nums.size

        val back = IntArray(newK)
        var j = newK - 1
        for (i in nums.size - 1 downTo 0) {
            if (i + newK > nums.size - 1) {
                back[j--] = nums[i]
            } else {
                nums[i + newK] = nums[i]
            }
        }

        for (i in 0 ..< back.size) {
            nums[i] = back[i]
        }
    }
}