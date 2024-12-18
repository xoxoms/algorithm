class Soldier {

    fun test(rating: IntArray): Int {
        var result = 0
        for (i in 0 .. rating.size - 2) {
            for (j in i + 1 until rating.size - 1) {
                for (k in j + 1 until rating.size) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        result++
                    }
                }
            }
        }

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Soldier().test(intArrayOf(2,5,3,4,1))
        }
    }
}