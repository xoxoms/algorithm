package top150_2

/**
 * 290. Word Pattern
 * 97/97
 * 효율은 좋게나왔으나, 진짜 되는대로 짰다..
 * split 같은 함수를 썼으면 좀더 깔끔해졌겠지만
 * 안해도되는 연산인 경우도 있어서 사용하지 않았다.
 */
class WordPattern {

    fun wordPattern(pattern: String, s: String): Boolean {
        val visited = mutableSetOf<String>()
        val map = mutableMapOf<Char, String>()
        var i = 0
        pattern.forEach {
            var prev = ""
            while (i < s.length && s[i] != ' ') {
                prev += s[i++]
            }
            if (prev == "") {
                return false
            }

            i++

            if (map[it] == null) {
                if (visited.contains(prev)) {
                    return false
                } else {
                    visited.add(prev)
                    map[it] = prev
                }
            }

            if (map[it]!! != prev) {
                return false
            }
        }

        if (i < s.length) {
            return false
        }

        return true
    }
}