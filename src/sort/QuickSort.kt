package sort

/**
 * 912. Sort an Array
 *
 * quickSort 구현
 */
class QuickSort {

    fun sortArray(nums: IntArray, left: Int = 0, right: Int = nums.size - 1): IntArray {
        if (left >= right) {
            return nums
        }

        val pivot = nums[(left + right) / 2]
        var l = left
        var r = right

        while (l <= r) {
            if (nums[l] < pivot) {
                l++
            } else if (nums[r] > pivot) {
                r--
            } else {
                swap(nums, l++, r--)
            }

        }

        sortArray(nums, left, r)
        sortArray(nums, l, right)

        return nums
    }

    private fun swap(nums: IntArray, p1: Int, p2: Int) {
        val temp = nums[p1]
        nums[p1] = nums[p2]
        nums[p2] = temp
    }
}

fun main() {
    val arr = intArrayOf(-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39)
//    val arr = intArrayOf(-4,0,7,4,9,-5,-1,0,-7,-1)
//    val arr = intArrayOf(9, 1, 3, 5, 4, 6, 8, 7, 2, 0)
//    val arr = intArrayOf(-1,2,-8,-10)
//    val arr = intArrayOf(3,4,2,2,1)
//    val arr = intArrayOf(5,1,1,2,0,0)
    QuickSort().sortArray(arr)
    arr.forEach {
        print("${it},")
    }
}