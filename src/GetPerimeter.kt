class GetPerimeter {

    fun test(nums: IntArray): Long {
        if (nums.size < 3) { return -1 }
        var result = -1L
        nums.sorted()
            .fold(0L) { acc, i ->
                val sum = acc + i
                if (i < acc) result = sum
                sum
            }

        return result
    }

    fun test2(nums: IntArray): Long {
        if (nums.size < 3) { return -1 }
        nums.sort()

        var sum = 0L
        nums.forEach { sum += it }
        for (i in nums.size - 1 downTo 2) {
            val num = nums[i]
            if (sum - num > num) {
                return sum
            } else {
                sum -= num
            }
        }

        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GetPerimeter().test(intArrayOf(5,5,5))
            GetPerimeter().test(intArrayOf(300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987))
            GetPerimeter().test(intArrayOf(1,5,1,7))
            GetPerimeter().test(intArrayOf(1,12,1,2,5,50,3))
        }
    }
}