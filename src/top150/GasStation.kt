package top150

/**
 * 134. Gas Station !!
 * O(N) 2h
 * Greedy
 * 총 가스가 총 코스트보다 작으면 -1 응답한다.
 * 배열을 순환한다.
 * 현재까지 더한 값이 0보다 작으면 해당 원소는 제외한다.
 * 현재까지 더한 값이 0보다 크면 총 값에 더하고 다음 원소로 넘어간다.
 * 다시, 현재까지 더한 값이 0보다 크면 다음 원소로 넘어간다.
 * 중간에 덧셈 후 작은 값이 있다면 해당 값은 결과값이 될수없으므로 제외한다.
 * 총 가스가 총 코스트보다 작으면 -1을 응답하는 것으로 게런티가 됐다.
 * 반드시 양수로 전환되는 케이스가 발생한다.
 */
class GasStation {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val list = IntArray(gas.size)
        var totalSum = 0
        var totalCost = 0
        for (i in 0 until gas.size) {
            list[i] = gas[i] - cost[i]
            totalSum += gas[i]
            totalCost += cost[i]
        }

        if (totalSum < totalCost) {
            return -1
        }

        var result = -1
        var sum = 0
        for (i in 0 until gas.size) {
            sum += list[i]
            if (sum < 0) {
                sum = 0
                result = -1
            } else if (result == -1) {
                result = i
            }
        }

        return result
    }
}

fun main() {
    println(GasStation().canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)))
}