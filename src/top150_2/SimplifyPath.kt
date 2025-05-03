package top150_2

import java.util.Stack

/**
 * 71. Simplify Path
 * 1h
 * 방향성은 금방 정했기 때문에 어렵다기보다는..막 푸느라 오래걸렸다..
 * =================
 * 문자를 순회하며 이전값을 기록한다. /를 만나면 리스트에 넣는다.
 * 리스트를 순회하며 ..를 만나면 result stack.pop()한다.
 */
class SimplifyPath {
    fun simplifyPath(path: String): String {
        val dirs = mutableListOf<String>()

        var i = 0
        var prev = ""
        while (i < path.length) {
            if (path[i] == '/') {
                dirs.add(prev)
                prev = ""
            } else {
                prev += path[i]
            }
            i++
        }
        dirs.add(prev)

        var result = Stack<String>()
        dirs
            .filter { it != "." && it != "" }
            .forEach { t ->
                if (t == "..") {
                    if (result.isNotEmpty()) {
                        result.pop()
                    }
                } else {
                    result.add(t)
                }
            }

        return result.joinToString("/", "/")
    }
}

fun main() {
    println(SimplifyPath().simplifyPath("/."))
    println(SimplifyPath().simplifyPath("/a/./b/../../c/"))
    println(SimplifyPath().simplifyPath("/../"))
    println(SimplifyPath().simplifyPath("/home/user/Documents/../Pictures"))
    println(SimplifyPath().simplifyPath("/a//b////c/d//././/.."))
}