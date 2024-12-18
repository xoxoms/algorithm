class ReturnDigitFromString {

    fun test(s: String): Int {
        var i = 0
        var sign = 1
        var sum = 0

        while (i < s.length && s[i] == ' ') i++
        if (i < s.length && (s[i] == '-' || s[i] == '+')) {
            sign = if (s[i++] == '-') -1 else 1
        }

        while (i < s.length && s[i] in '0'..'9') {
            val digit = s[i++] - '0'

            if (sum > (Int.MAX_VALUE - digit) / 10) return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            sum = sum * 10 + digit
        }

        return sum  * sign
    }

    fun myAtoi(s: String): Int {
        var i = 0
        var sign = 1
        var res = 0

        // Step 1: Skip leading spaces
        while (i < s.length && s[i] == ' ') i++

        // Step 2: Check sign
        if (i < s.length && (s[i] == '+' || s[i] == '-')) {
            sign = if (s[i++] == '-') -1 else 1
        }

        // Step 3: Convert digits to integer
        while (i < s.length && s[i] in '0'..'9') {
            val digit = s[i++] - '0'

            // Step 4: Handle overflow/underflow
            if (res > (Int.MAX_VALUE - digit) / 10) return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE

            res = res * 10 + digit
        }

        return res * sign
    }

    fun test4(s: String): Int {
        val trim = s.trimStart()
        var sign = 1
        var start = 0

        if (trim.isEmpty()) { return 0 }
        if (trim[0] == '-') {
            sign = -1
            start = 1
        } else if (trim[0] == '+') {
            sign = 1
            start = 1
        }

        var from = -1
        var to = trim.length - 1
        for (i in start until trim.length) {
            val value = trim[i]
            val isDigit = value.isDigit()

            if (from == -1) {
                if (isDigit) {
                    if (value != '0') {
                        from = i
                        to = i
                    }
                } else {
                    return 0
                }
            } else {
                if (!isDigit) {
                    break
                } else {
                    to = i
                }
            }
        }

        if (from == -1) {
            return 0
        }

        val result = trim.substring(from, to + 1)
        if (result.length < 10) {
            return result.toInt() * sign
        }

        val asLong = if (result.length > 10) {
            Long.MAX_VALUE * sign
        } else {
            result.toLong() * sign
        }

        return if (asLong > Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else if (asLong < Int.MIN_VALUE) {
            Int.MIN_VALUE
        } else {
            asLong.toInt()
        }
    }

    fun test3(s: String): Int {
        val trim = s.trimStart()
        if (trim == "") { return 0 }
        var idx = 0
        var sign = 1
        if (trim[0] == '-' || trim[0] == '+') {
            if (trim[0] == '-') sign = -1
            idx++
        }
        if (idx == trim.length || !trim[idx].isDigit()) {
            return 0
        }

        var start = false
        val sb = StringBuilder()
        for (i in idx until trim.length) {
            val c = trim[i]
            val isDigit = c.isDigit()
            if (start) {
                if (isDigit) {
                    sb.append(c)
                } else {
                    break
                }
            } else {
                if (isDigit) {
                    if (c != '0') {
                        start = true
                        sb.append(c)
                    }
                } else {
                    return 0
                }
            }
        }

        if (start == false) {
            return 0
        }

        val result = sb.toString()
        val asLong = if (result.length > 10) {
            Long.MAX_VALUE * sign
        } else {
            result.toLong() * sign
        }

        return if (asLong > Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else if (asLong < Int.MIN_VALUE) {
            Int.MIN_VALUE
        } else {
            asLong.toInt()
        }
    }

    fun test2(s: String): Int {
        val trim = s.trim()
        val extracted = "^[0-9,+-]?[0-9]+".toRegex().find(trim) ?: return 0
        val from = "[1-9]".toRegex().find(extracted.value)?.range?.last ?: return 0
        val to = extracted.range.last
        val result = trim.substring(from, to + 1)
        val sign = if (trim.startsWith("-")) -1 else 1

        val asLong = if (result.length > 10) {
            Long.MAX_VALUE * sign
        } else {
            result.toLong() * sign
        }

        return if (asLong > Int.MAX_VALUE) {
            Int.MAX_VALUE
        } else if (asLong < Int.MIN_VALUE) {
            Int.MIN_VALUE
        } else {
            asLong.toInt()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ReturnDigitFromString().test("+1"))
            println(ReturnDigitFromString().test("0-1"))
            println(ReturnDigitFromString().test("3.14159"))
            println(ReturnDigitFromString().test(" "))
            println(ReturnDigitFromString().test("000000000000000000"))
            println(ReturnDigitFromString().test("+"))
            println(ReturnDigitFromString().test(""))
            println(ReturnDigitFromString().test("   -042"))
            println(ReturnDigitFromString().test("20000000000000000000"))
            println(ReturnDigitFromString().test("3"))
            println(ReturnDigitFromString().test("-91283472332"))
            println(ReturnDigitFromString().test("-042"))
            println(ReturnDigitFromString().test("42"))
            println(ReturnDigitFromString().test(" 1337c0d3"))
            println(ReturnDigitFromString().test("1337c0d3"))
            println(ReturnDigitFromString().test("w1337c0d3"))
        }
    }
}