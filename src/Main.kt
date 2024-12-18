class Main {

    fun test(): Int {
        return 0
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Main().test())
        }
    }
}