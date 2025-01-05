package top150

/**
 * 189. Rotate Array
 * 30m. O(n)
 * shift 수는 배열 사이즈 % k 하면되겠다.
 * 0번째는 0+shift
 * 1번째는 1+shift
 * ....
 * index+shift가 size보다 커지면,
 * index+shift % size 하면되겠다.
 */
class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k < 0) return

        val size = nums.size
        val shift = k % size
        val newArray = IntArray(nums.size)
        for (i in 0 until size) {
            if (i + shift < size) {
                newArray[i + shift] = nums[i]
            } else {
                newArray[(i + shift) % size] = nums[i]
            }
        }

        for (i in 0 until newArray.size) {
            nums[i] = newArray[i]
        }
    }
}

fun main() {

//    val target = intArrayOf(1, 2)
//    RotateArray().rotate(target, 3)
//    println(target)
//
    val target = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    RotateArray().rotate(target, 3)
    println(target)
}