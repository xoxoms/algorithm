package top150

/**
 * 15. 3Sum !!
 * O(N^2)
 * 계산을 위해 정렬해줄 핋요가 있다. O(NlogN)
 * i, j, k 세가지 인덱스가 필요하다.
 * i는 0으로 초기화하고 j는 i+1로, k는 j+1로 초기화한다.
 * nums[i]가 nums[i-1]과 같으면 계산에서 제외해야한다. 스킵한다.
 * i+j+k가 0보다 크면 k--, 0보다 작으면 j++한다.
 * 0과 같으면 결과에 추가한다.
 * 만약 j와 j+1값이 같다면 j++해준다.
 * ==================
 * i=0으로 j는 i+1로 초기환다.
 * i+j가 0이되는 값이 있는지 전부 bruteforce 검사한다.
 * 없으면 j++한다.
 * j가 nums.length-2랑 같아지면 i++하고 j도 초기화한다.
 * 반복한다.
 */
class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0 .. nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue }

            var j = i + 1
            var k = nums.size - 1
            while (j < k) {
                val threeSum = nums[i] + nums[j] + nums[k]
                if (threeSum < 0) {
                    j++
                } else if (threeSum > 0) {
                    k--
                } else {
                    result.add(listOf(nums[i], nums[j], nums[k]))
                    while (j++ < k) {
                        if (nums[j - 1] != nums[j]) {
                            break
                        }
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    println(ThreeSum().threeSum(intArrayOf(-1,0,1,2,0,-1,4)))
}