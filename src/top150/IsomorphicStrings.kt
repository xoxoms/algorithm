package top150

/**
 * 205. Isomorphic Strings
 * s를 순회한다.
 * s의 각 캐릭터와 t의 위치 값을 맵에 넣는다.
 * s가 이미 존재하는데 t가 기존과 다르면 false를 응답한다.
 * t로도 똑같이 반복
 */
class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = mutableMapOf<Char, Char>()
        for (i in 0..< s.length) {
            if (map[s[i]] == null) {
                map[s[i]] = t[i]
            } else if (map[s[i]] != t[i]) {
                 return false
            }
        }

        map.clear()
        for (i in 0..< t.length) {
            if (map[t[i]] == null) {
                map[t[i]] = s[i]
            } else if (map[t[i]] != s[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(IsomorphicStrings().isIsomorphic("badc", "baba"))
    println(IsomorphicStrings().isIsomorphic("egg", "add"))
}