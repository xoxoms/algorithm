package top150_2

import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters !!
 * 3h. 어려웠는데 결국 해결.
 * 비벼서 해결한거라 좀 아쉽다.
 * ========================
 * 현재 값이 맵에 없다면 다음 값으로 넘어간다.
 * 현재 값이 맵에 있으면, start를 맵에 저장된 값으로 변경한다.
 * start가 적은 값으로 변경되어선 안되므로, max(start, map[]) 처리해야한다.
 */
class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length < 2) { return s.length }

        val map = mutableMapOf<Char, Int>()
        var i = 0
        var result = 0
        var start = 0
        while (i < s.length) {
            if (map[s[i]] != null) {
                start = max(map[s[i]]!!, start)
            }

            result = max(result, i - start + 1)
            map[s[i]] = ++i
        }

        return result
    }
}