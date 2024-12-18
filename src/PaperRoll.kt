class PaperRoll {

    fun test(input: String) {
        val line1 = input.split("\n")[0]
        val line2 = input.split("\n")[1]
//        val line1 = readLine()!!
//        val line2 = readLine()!!

        val split1 = line1.split(" ")
        val size = split1[0].toInt()
        var remaining = split1[1].toInt()
        val list = line2.split(" ").map { it.toInt() }
        val max = list.maxOf { it }

        list.forEach {
            remaining -= (max - it)
            if (remaining < 0) {
                print("No way!")
                return
            }
        }

        if (remaining < list.size && remaining != 0) {
            print("No way!")
        }

        print("${max + (remaining / size)}")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PaperRoll().test("5 20\n4 3 7 1 6\n")
            PaperRoll().test("50 5000\n5 14 95 80 86 4 24 96 43 5 39 3 89 70 31 62 64 86 33 79 19 56 1 55 93 11 7 48 51 69 63 87 65 53 96 83 7 66 8 48 33 50 89 50 44 79 15 87 2 67")
        }
    }
}