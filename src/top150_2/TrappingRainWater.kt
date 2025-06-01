package top150_2

/**
 * 42. Trapping Rain Water !!
 * 두번째 하드문제. 1h
 * 풀기 어려운 미디움 수준 같았다.
 * 좀더 효율적으로 작성할 수 있어보인다.
 * =====================
 * 0번째를 좌측 max 값으로 지정한다.
 * 1번째부터 루핑한다.
 * max 값보다 작으면, 차액을 temp에 더한다.
 * max 값보다 크다면, temp를 결과에 더한다.
 * max를 갱신한다.
 *
 * 위를 반복하면 마지막 max 값 이후 건들이 결과에 반영되지 않는다.
 * 역방향으로 같은 로직을 수행하여 결과 값에 반영한다.
 */
class TrappingRainWater {

    fun trap(height: IntArray): Int {
        if (height.isEmpty()) { return 0 }
        var result = 0

        var leftMax = height[0]
        var leftPosition = 0

        var temp = 0
        for (i in 1 ..< height.size) {
            if (height[i] >= leftMax) {
                leftMax = height[i]
                leftPosition = i
                result += temp
                temp = 0
            } else {
                temp += leftMax - height[i]
            }
        }

        if (temp != 0) {
            temp = 0
            var rightPosition = height.size - 1
            var rightMax = height[rightPosition]

            for (i in rightPosition - 1 downTo leftPosition) {
                if (height[i] >= rightMax) {
                    rightMax = height[i]
                    rightPosition = i
                    result += temp
                    temp = 0
                } else {
                    temp += rightMax - height[i]
                }
            }
        }

        return result
    }
}