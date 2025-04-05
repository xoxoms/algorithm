package top150_2

import kotlin.math.max

/**
 * 11. Container With Most Water
 * 투포인터로 해결한다.
 * 좌측이 우측 기등보다 크면, 우측기둥 사이즈 * 거리를하고 우측 인덱스--
 * 반대면 좌측 인덱스++한다.
 * 글로벌 값을 저장 후 반환한다.
 */
class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1

        var result = 0
        while (i < j) {
            val d = j - i
            result = max(result, if (height[i] > height[j]) {
                height[j--]
            } else {
                height[i++]
            } * d)
        }

        return result
    }
}