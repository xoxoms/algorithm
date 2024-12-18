import kotlin.math.max
import kotlin.math.min

class WaterContainer {

    fun test(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var max = 0

        while (l < r) {
            val width = r - l
            max = maxOf(max, width * min(height[l], height[r]))
            if (height[l] < height[r]) {
                l++
            } else {
                r--
            }
        }

        return max
    }

    fun test2(height: IntArray): Int {
        var max = 0

        for (i in 0 until height.size - 1) {
            var j = height.size - 1
            var candidate = 0
            if (height[i] * (height.size - 1 - i) < max) {
                continue
            }

            while (j > i) {
                if (height[j] > candidate) {
                    candidate = min(height[j], height[i])
                    max = max((j - i) * candidate, max)
                    if (height[j] > height[i]) {
                        break
                    }
                }
                j--
            }
        }

        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            WaterContainer().test(intArrayOf(1,8,6,2,5,4,8,3,7))
        }
    }
}