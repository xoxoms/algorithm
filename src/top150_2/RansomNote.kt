package top150_2

/**
 * 383. Ransom Note
 * 난이도는 easy인데..99%달성은 못했다.
 * ==============================
 * 최대 탐색할 대상은 ransomNote니까
 * ransomNote 값들을 맵에 넣어두고 카운팅한다.
 * magazine을 순회하며 카운트 차감하고
 * ransomNote 모든 값을 처리했다면 얼리리턴한다.
 */
class RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        ransomNote.forEach { map[it] = map.computeIfAbsent(it) { 0 } + 1 }
        var remain = ransomNote.length
        magazine.forEach {
            if (map[it] != null) {
                map[it] = map[it]!! - 1
                if (map[it] == 0) { map.remove(it) }
                remain--

                if (remain == 0) {
                    return true
                }
            }
        }

        return false
    }

    fun canConstruct2(ransomNote: String, magazine: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        ransomNote.forEach { map[it] = map.computeIfAbsent(it) { 0 } + 1 }

        val set = mutableMapOf<Char, Int>()
        magazine.forEach {
            set.computeIfAbsent(it) { 0 }
            set[it] = set[it]!! + 1
        }
        ransomNote.forEach {
            if (set[it] != null) {
                set[it] = set[it]!! - 1
                if (set[it] == -1) {
                    return false
                }
            } else {
                return false
            }
        }

        return true
    }
}