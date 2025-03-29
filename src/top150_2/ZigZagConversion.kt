package top150_2

/**
 * 6. Zigzag Conversion
 * numRows만큼 루핑한다.
 * 0번과 마지막의 경우 한번씩만 찍으면되지만,
 * 그 사이 건들은 두번씩 찍어줘야한다.
 */
class ZigZagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) { return s }
        val endIndex = numRows - 1
        val interval = endIndex * 2
        val sb = StringBuilder()

        for (i in 0 ..< numRows) {
            var j = i
            while (j < s.length) {
                sb.append(s[j])
                if (i != 0 && i != endIndex) {
                    val mid = j + ((endIndex - i) * 2)
                    if (mid < s.length) {
                        sb.append(s[mid])
                    }
                }

                j += interval
            }
        }

        return sb.toString()
    }
}