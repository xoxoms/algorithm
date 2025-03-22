package top150_2

/**
 * 134. Gas Station
 * 매 인덱스마다 토탈값에 더해준다.
 * gas[i] - cost[i]가 양수라면 result 후보이다.
 * 위 빼고 남은 값을 remain에 더해준다.
 * 루핑하다가 remain이 0보다 작게되면 현재 후보는 버려져야한다.
 * -1로 업데이트한다.
 *
 * 최종적으로 total 값이 0 미만이면 -1을, 아니면 result 값을 반환한다.
 * ============
 * 어려운 문재는 아닌거같다.
 * 30m
 */
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var total = 0
        var remain = 0
        var start = -1

        for (i in 0 ..< gas.size) {
            val sub = gas[i] - cost[i]
            total += sub
            remain += sub

            if (remain < 0) {
                remain = 0
                start = -1
            } else if (start == -1) {
                start = i
            }
        }

        return if (total < 0) {
            -1
        } else {
            start
        }
    }
}

fun main() {

}