class Subset {

    fun test(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val current = mutableListOf<Int>()
        backTracking(nums, result, current, 0)
        return result
    }

    private fun backTracking(nums: IntArray, result: MutableList<MutableList<Int>>, current: MutableList<Int>, idx: Int) {
        result.add(ArrayList(current))

        for (i in idx until nums.size) {
            current.add(nums[i])
            backTracking(nums, result, current, i + 1)
            current.removeLast()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Subset().test(intArrayOf(1, 2, 3, 4))
        }
    }
}