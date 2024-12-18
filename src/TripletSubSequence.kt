class TripletSubSequence {

    fun test(nums: IntArray): Boolean {
        if (nums.size < 3) { return false }
        var one = Int.MAX_VALUE
        var two = Int.MAX_VALUE

        for (num in nums) {
            if (num <= one) {
                one  = num
            } else if (num <= two) {
                two = num
            } else {
                return true
            }
        }
        return false
    }

    fun test2(nums: IntArray): Boolean {
        if (nums.size < 3) { return false }

        val result = mutableListOf<Int>()
        backTracking(nums, result, 0)
        return result.size >= 3
    }

    private fun backTracking(nums: IntArray, result: MutableList<Int>, idx: Int) {
        if (idx == nums.size) { return }

        for (i in idx until nums.size) {
            if (result.size == 0 || result.last() < nums[i]) { result.add(nums[i]) }
            else { continue }

            backTracking(nums, result, i + 1)
            if (result.size == 3) { return }
            else {
                result.removeLast()
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(TripletSubSequence().test(intArrayOf(0,4,2,1,0,-1,-3)))
            println(TripletSubSequence().test(intArrayOf(20,100,10,12,5,13)))
            println(TripletSubSequence().test(intArrayOf(1,2,3,4,5)))
            println(TripletSubSequence().test(intArrayOf(5, 4, 3, 2 ,1)))
            println(TripletSubSequence().test(intArrayOf(1,2,3)))
            println(TripletSubSequence().test(intArrayOf(2,1,5,0,4,6)))
        }
    }
}