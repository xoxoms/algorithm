import kotlin.math.max

class Purse {

    fun test(array: IntArray): Long {
        val pulseA = IntArray(array.size)
        val pulseB = IntArray(array.size)
        for (i in array.indices) {
            if (i%2==0) {
                pulseA[i] = 1
                pulseB[i] = -1
            } else {
                pulseA[i] = -1
                pulseB[i] = 1
            }
        }


        for (i in array.indices) {
            pulseA[i] *= array[i]
            pulseB[i] *= array[i]
        }

        return max(get(pulseB), get(pulseA))
    }

    fun get(array: IntArray): Long {
        var max = 0L

        for (i in 0..<array.size - 1) {
            var sum = 0L
            for (k in i until array.size) { sum += array[k] }
            if (max < sum) { max = sum }
            for (j in array.size - 1 downTo i + 1) {
                sum -= array[j]
                if (sum - array[j] > max) {
                    max = sum
                }
            }
        }

        return max
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Purse().test(intArrayOf(3,2,-2,5,-1,7)))
//            println(Purse().test(intArrayOf(2,3,-6,1,3,-1,2,4)))
//            println(Purse().test(intArrayOf(3,2,-2,5,-1,7,9)))
        }
    }
}