package top150_2

/**
 * 205. Isomorphic Strings
 * 난이도는 easy인데..99%달성은 못했다.
 * =============================
 * for문을 루핑하며 문자하나씩 비교한다.
 * 비교에는 s의 i번째를 t의 i번째 캐릭터로 치환한 후 비교한다.
 * 만약 처음 나타난 글자면 맵에 넣는다.
 * 두번째 이상 나온 경우 맵에 저장된 값과 같은지 비교한다.
 * s[i]의 값이 처음인데 t[i]는 처음이 아닐수있으므로 방문처리한다.
 */
class IsomorphicString {

    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()
        val visited = mutableSetOf<Char>()
        for (i in 0 ..< s.length) {
            if (map[s[i]] == null) {
                if (visited.contains(t[i])) {
                    return false
                } else {
                    visited.add(t[i])
                    map[s[i]] = t[i]
                }
            } else if (map[s[i]] != t[i]) {
                return false
            }
        }

        return true
    }
}