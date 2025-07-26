package top150_2

/**
 * 68. Text Justification
 * 1h 30m
 * 풀이 방식이 잘못됐는지, 알고리즘이 어렵거나 하지는 않았다..
 * ==============================================
 * 리스트를 초기화한다.
 * 인자 워드를 수회한다.
 * 인자 사이즈를 누적한다. maxWidth보다 커지면 더이상 처리할 수 없으므로 새로운 리스트를 초기화한다.
 *
 * 리스트 분배가 끝나면 마지막 청크인지, 리스트 내의 원소가 1개인지 그외인지 구분하여 정렬 기준을 정한다.(left justification or else)
 * 왼쪽 정렬이면 문자를 sb에 더한후 나머지 패딩 처리
 * 그외, 기본 패딩 + 추가 패딩 값을 구해 패딩 처리
 * 결과 반환
 */
class TextJustification {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()

        val split = mutableListOf<MutableList<String>>()

        var remaining = maxWidth

        var targetList = mutableListOf<String>()
        split.add(targetList)
        for (string in words) {
            if (remaining - targetList.size - string.length < 0) {
                targetList = mutableListOf()
                split.add(targetList)
                remaining = maxWidth
            }

            remaining -= string.length
            targetList.add(string)
        }

        for (idx in 0 ..< split.size) {
            val sb = StringBuilder()
            val words = split[idx]
            if (split.size - 1 == idx || words.size == 1) {
                var count = 0
                for (i in 0 ..< words.size - 1) {
                    sb.append(words[i] + " ")
                    count += words[i].length + 1
                }

                sb.append(words.last())
                count += words.last().length
                for (i in count ..< maxWidth) {
                    sb.append(" ")
                }
            } else {
                val totalLength = words.sumOf { it.length }
                val remain = maxWidth - totalLength
                val minPadSize = remain / (words.size - 1)
                val extraPad = remain % (words.size - 1)

                for (i in 0 ..< words.size - 1) {
                    sb.append(words[i])
                    for (i in 0 ..< minPadSize) {
                        sb.append(" ")
                    }

                    if (i < extraPad) {
                        sb.append(" ")
                    }
                }

                sb.append(words.last())
            }

            result.add(sb.toString())
        }

        return result
    }
}

fun main() {
    TextJustification().fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16)
    TextJustification().fullJustify(arrayOf(" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",), 16)
}