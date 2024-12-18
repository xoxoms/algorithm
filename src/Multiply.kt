class Multiply {

    fun test(num1: String, num2: String):String {
        if (num1 == "0" || num2 == "0") { return "0" }

        val greater = num1
        val lesser = num2
        var result = "0"

        var i = greater.length - 1
        var j = lesser.length - 1

        do {
            val zeroCount = greater.length - 1 - i + lesser.length - 1 - j

            var g = greater[i].digitToInt()
            var l = lesser[j].digitToInt()
            var calc: String = (g * l).toString()

            for (k in 0 ..< zeroCount) {
                if (result.length - zeroCount + k < result.length) {
                    calc += result[result.length - zeroCount + k]
                } else {
                    calc += "0"
                }
            }

            var over = 0
            var k = zeroCount
            var gt = calc
            var lt = result
            if (calc.length < result.length) {
                gt = result
                lt = calc
            }
            while (gt.length - 1 - k >= 0) {
                val resultValue = if (lt.length - 1 - k < 0) {
                    0
                } else {
                    lt[lt.length - 1 - k].digitToInt()
                }

                val sum = gt[gt.length - 1 - k].digitToInt() + resultValue + over
                gt = gt.replaceRange(gt.length - 1 - k, gt.length - 1 - k + 1, (sum % 10).toString())
                over = sum / 10
                k++
            }
            if (over != 0) {
                gt = over.toString() + gt
            }


            result = gt

            if (i == 0) {
                i = greater.length - 1
                j--
            } else {
                i--
            }
        } while (j >= 0)

        return result
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Multiply().test("123", "456")
            Multiply().test("256117489511377083148593685533950561400363410418754703282767252221661609163404299", "61200496111643709081218550902198211480012378840070191147459688611759881218205422431757614")
        }
    }
}