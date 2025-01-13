package top150

/**
 * 49. Group Anagrams
 */
class GroupAnagram {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for (i in 0 .. strs.size - 1) {
            map.computeIfAbsent(strs[i].toCharArray().sorted().joinToString("")) { mutableListOf() }.add(strs[i])
        }

        return map.values.toList()
    }

    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        return strs.groupBy {
            it.map { item -> item.toString() }.sorted()
        }.values
            .toList()
    }
}

fun main() {
    println(GroupAnagram().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
}