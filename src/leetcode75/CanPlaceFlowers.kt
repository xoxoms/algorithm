package leetcode75

class CanPlaceFlowers {

    /**
     * 605. Can Place Flowers
     * 현재위치 기준 양옆 값을 구해서 0이면 마크한다.
     */
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

        var remain = n
        for (i in 0 ..< flowerbed.size) {
            if (flowerbed[i] != 0) { continue }
            val left = if (i == 0) {
                0
            } else {
                flowerbed[i - 1]
            }

            val right = if (i == flowerbed.size - 1) {
                0
            } else {
                flowerbed[i + 1]
            }

            if (left + right == 0) {
                remain--
                flowerbed[i] = 1
            }
        }

        return remain < 1
    }
}

fun main() {
    println(CanPlaceFlowers().canPlaceFlowers(intArrayOf(1,0,0,0,0,1), 1))
}