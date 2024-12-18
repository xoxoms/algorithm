import kotlin.math.absoluteValue

class ReturnReversed {

    fun test(x: Int): Int {
        if (x == 0) return 0

        val sign = if (x < 0) -1 else 1
        val sb = StringBuilder()
        val asString = x.toLong()
            .absoluteValue
            .toString()
        for (i in asString.length - 1 downTo 0) {
            sb.append(asString[i])
        }

        val asReversedLong = sb.toString().toLong() * sign
        if (asReversedLong < Int.MIN_VALUE || asReversedLong > Int.MAX_VALUE) {
            return 0
        } else {
            return asReversedLong.toInt()
        }
    }

    fun test1(x: Int): Int {
        if (x == 0) return x

        val sign = if (x < 0) -1 else 1
        val sb = StringBuilder()
        var asLong = x.toLong().absoluteValue
        while (asLong > 0) {
            sb.append(asLong % 10)
            asLong /= 10
        }

        val result = sb.toString().toLong()
        return if (result in Int.MIN_VALUE .. Int.MAX_VALUE) {
            sign * result.toInt()
        } else {
            0
        }
    }

    fun test2(x: Int): Int {
        if (x == 0 || x == Int.MIN_VALUE) {
            return 0
        }

        val result = x.absoluteValue.toString().reversed()
        val sign = if (x < 0) -1 else 1
        val longValue = result.toLong() * sign
        return if (sign == 1 && longValue >= Int.MAX_VALUE) {
            0
        } else if (sign == -1 && longValue < Int.MIN_VALUE){
            0
        } else {
            result.toInt() * sign
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ReturnReversed().test(-1563847412)
//            ReturnReversed().test(-2147483648)
//            ReturnReversed().test(123)
//            ReturnReversed().test(-123)
//            ReturnReversed().test(120)
        }
    }
}