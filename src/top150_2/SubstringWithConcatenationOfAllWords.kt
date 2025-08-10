package top150_2

/**
 * 30. Substring with Concatenation of All Words !!
 * 상당히 비효율적으로 풀었다.
 * ==================================================
 * 1. word 별 갯수 카운트를 기록한다.
 * 2. 슬라이딩 윈도우 처리를 위해 좌측에서 움직일 offset 기준을 구한다. (이 문제의 메카니즘으로 인해 words[0].length까지만 확인하면된다.)
 * 3. 현재 left position에서부터 totalLength길이만큼 잘라서 각 워드 별 카운트를 구한후 맵에 넣는다.
 * 4. 맵의 카운팅된 갯수와 실제 워드 카운팅 갯수가 일치하면 해당 인덱스를 결과에 넣는다.
 * 5. left를 words[0].length만큼 움직인다.
 * 6. currentMap에 기존 최앞단 word를 -1하고, 마지막 word를 +1한다.
 * 7. 다시 4)번을 수행하여 모든 워드가 카운트만큼 포함되는지 확인하여 결과를 만든다.
 */
class SubstringWithConcatenationOfAllWords {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()
        if (words.isEmpty()) { return result }

        var i = 0
        val length = words.first().length
        val totalLength = length * words.size
        if (s.length < totalLength) { return result }

        val wordFrequencyMap = words
            .groupingBy { it }
            .eachCount()

        while (i < length && i + totalLength <= s.length) {
            val currentFrequencyMap = s.substring(i, totalLength + i)
                .chunked(length)
                .filter { wordFrequencyMap.contains(it) }
                .groupingBy { it }
                .eachCount()
                .toMutableMap()

            var j = i
            while (true) {
                if (wordFrequencyMap == currentFrequencyMap) {
                    result.add(j)
                }

                if (j + totalLength + length > s.length) {
                    break
                }

                val first = s.substring(j, j + length)
                if (wordFrequencyMap.contains(first)) {
                    currentFrequencyMap[first] = currentFrequencyMap[first]!! - 1
                }

                val last = s.substring(j + totalLength, j + totalLength + length)
                if (wordFrequencyMap.contains(last)) {
                    currentFrequencyMap.computeIfAbsent(last) { 0 }
                    currentFrequencyMap[last] = currentFrequencyMap[last]!! + 1
                }

                j += length
            }

            i++
        }

        return result
    }
}

fun main() {
    println(SubstringWithConcatenationOfAllWords().findSubstring("ababababab", arrayOf("ababa","babab")))
    println(SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word")))
    println(SubstringWithConcatenationOfAllWords().findSubstring("barfoofoobarthefoobarman", arrayOf("foo","bar","the")))
    println(SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","best","good","good")))
    println(SubstringWithConcatenationOfAllWords().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","word")))
}