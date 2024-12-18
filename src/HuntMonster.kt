class HuntMonster {

    fun test() {
        val line1 = "4"
        val line2 = "2 1 2 4"

        val size = line1.toInt()
        val monster = line2
            .split(" ")
            .map { it.toInt() }
            .toIntArray()

        var currentSize = size
        var count = 0

        while (currentSize > 0) {
            for (i in 0 until size) {
                val value = monster[i]
                if (value <= 0) { continue }
                count++
                monster[i]--

                if (value - 1 == 0) {
                    currentSize--
                    monster[i] = -count
                }
            }
        }

        monster.forEach { println(-it) }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            HuntMonster().test()
        }
    }
}