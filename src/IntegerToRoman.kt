class IntegerToRoman {
    fun test(num: Int): String {
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        var n = num
        var s = ""
        var i = 0
        do {
            if (values[i] <= n) {
                n = n - values[i]
                s += symbols[i]
            } else {
                i++
            }
        } while (n != 0)

        return s
    }

    fun test2(num: Int): String {
        val sb = StringBuilder()
        var d = 1000
        val ten = listOf("M", "C", "X", "I")
        val five = listOf("", "D", "L", "V")
        // MMMDCCXLIX
        var curr = 0

        do {
            val divide = (num / d) % 10
            if (divide > 0) {
                if (divide == 4) {
                    sb.append(ten.get(curr))
                    sb.append(five.get(curr))
                } else if (divide == 9) {
                    sb.append(ten.get(curr))
                    sb.append(ten.get(curr - 1))
                } else {
                    if (divide > 4) {
                        sb.append(five.get(curr))
                    }
                    val repeat = divide % 5

                    for (i in repeat downTo 1) {
                        sb.append(ten.get(curr))
                    }
                }
            }

            d = d / 10
            curr++
        } while (d > 0)

        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            IntegerToRoman().test(3749)
            IntegerToRoman().test(1994)
        }
    }
}