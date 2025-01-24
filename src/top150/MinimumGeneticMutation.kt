package top150

import java.util.*

/**
 * 433. Minimum Genetic Mutation
 * 뱅크를 초기화한다. 이때 시작 값도 같이 넣고 엔드부터 역순으로 반복한다.
 * endGene을 큐에 넣고 아래를 반복한다.
 * 큐를 소모한다.
 * 뱅크 내에서 현 원소와 한자리 값만 다른 값들로 추린다.
 * 해당 값이 시작값이면 카운트를 리턴한다.
 * ====================================
 * target에 endGene를 할당한다.
 * 각 자리별 하나씩 바꿔서 가능한 모든 값을 구한다.
 * startGene과 같으면 현재 변경횟수를 리턴한다.
 * 아니면 전부 큐에 넣는다.
 * 방문처리한다.
 * bank에 해당 값과 동일한게 있으면 큐에 넣는다.
 * 없으면 -1
 *
 */
class MinimumGeneticMutation {

    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (bank.isEmpty() || !bank.contains(endGene)) return -1

        val newBanks = mutableListOf<String>()
        for (s in bank) { newBanks.add(s) }
        newBanks.add(startGene)
        val queue = LinkedList<String>()
        queue.add(endGene)

        var count = 0
        val visited = mutableSetOf<String>()
        while (queue.isNotEmpty()) {
            val polls = mutableListOf<String>()
            while (queue.isNotEmpty()) {
                polls.add(queue.poll())
            }
            if (polls.isEmpty()) { break }

            count++
            for (poll in polls) {
                for (bankItem in newBanks) {
                    var diff = 0
                    for (i in bankItem.indices) {
                        if (bankItem[i] != poll[i]) {
                            diff++
                        }
                    }

                    if (diff == 1) {
                        if (bankItem.contentEquals(startGene)) { return count }
                        if (visited.contains(bankItem)) {
                            continue
                        } else {
                            visited.add(bankItem)
                        }

                        queue.add(bankItem)
                    }
                }
            }
        }

        return -1
    }
//    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
//        for (s in bank) { if (startGene == s) { return 1 } }
//        val parse = { char: Char ->
//            when (char) {
//                'A' -> 0
//                'C' -> 1
//                'G' -> 2
//                else -> 3
//            }
//        }
//        val mutation = { number: Int -> (number + 1) % 4 }
//
//        val parsedStartGene = startGene.map { parse(it) }.toIntArray()
//        val parsedEndGene = endGene.map { parse(it) }.toIntArray()
//        bank.plus(startGene)
//        val parsedBank = bank.map {str -> str.map { parse(it) }.toIntArray() }
//        val visited = mutableSetOf<IntArray>()
//        val queue = LinkedList<IntArray>()
//        queue.add(parsedEndGene)
//
//        var count = 0
//        while (queue.isNotEmpty()) {
//            val polls = mutableListOf<IntArray>()
//            while (queue.isNotEmpty()) { polls.add(queue.poll()) }
//            if (polls.isEmpty()) break
//            count++
//
//            for (poll in polls) {
//                for (bankItem in parsedBank) {
//                    var diff = 0
//                    for (i in 0 ..< bankItem.size) {
//                        if (bankItem[i] != poll[i]) {
//                            diff++
//                        }
//                    }
//
//                    if (diff <= 1) {
//                        if (bankItem.contentEquals(parsedStartGene)) {
//                            return count
//                        }
//                        if (visited.contains(bankItem)) {
//                            continue
//                        } else {
//                            visited.add(bankItem)
//                        }
//
//                        queue.add(bankItem)
//                    }
//                }
//            }
//        }
//
//        return -1
//    }
}

fun main() {
//    println(
//        MinimumGeneticMutation().minMutation(
//            "AACCGGTT",
//            "AAACGGTA",
//            arrayOf("AACCGGTA","AACCGCTA","AAACGGTA")
//        )
//    )

    println(
        MinimumGeneticMutation().minMutation(
            "AAAAAAAA",
            "CCCCCCCC",
            arrayOf("AAAAAAAA","AAAAAAAC","AAAAAACC","AAAAACCC","AAAACCCC","AACACCCC","ACCACCCC","ACCCCCCC","CCCCCCCA")
        )
    )
}