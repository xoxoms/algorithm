package top150

/**
 * 11. Container With Most Water
 * 최대값을 0으로 지정한다.
 * 배열 양끝을 i와 j로 선언한다.
 * i와 j의 크기를 max와 비교하여 갱신한다.
 * i와 j중 작은값의 엔덱스를 담으로 갱신한다.
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var result = 0

        while (i < j) {
            val l = j - i
            val h = if (height[i] < height[j]) {
                height[i++]
            } else {
                height[j--]
            }

            result = maxOf(result, h * l)
        }

        return result
    }
}

fun main() {
    println(ContainerWithMostWater().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}