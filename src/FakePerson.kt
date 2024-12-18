import kotlin.concurrent.thread

fun main() {
    for (i in 0..10) {
        thread(isDaemon = true)
            {
                val fakePersons = mapOf(
                    "Alice1" to TestPerson.Alice1,
                    "Alice" to TestPerson.Alice,
                    "Bob" to TestPerson.Bob,
                    "Bob2" to TestPerson.Bob2,
                    "Bob3" to TestPerson.Bob3,
                )
                println("${Thread.currentThread().name}, $fakePersons")
            }.run()
    }

//    println(TestPerson.Alice1.age)
//    println(TestPerson.Alice.age)
//    println(TestPerson.Bob.age)
//    println(TestPerson.Bob2.age)
//    println(TestPerson.Bob3.age)
//    println(TestPerson.fakePersons)
//    println(TestPerson.fakePersons)
//    println(TestPerson.Alice.age)
    println("${Thread.currentThread().name}, ${TestPerson.fakePersons}")
}

sealed class TestPerson(
    val name: String,
    val age: Int,
) {
    init {
        print(this.name)
        println(this.age)
    }

    override fun toString(): String {
        return "TestPerson(name='$name', age=$age)"
    }
    data object Alice1: TestPerson("Alice1", 1)
    data object Alice: TestPerson("Alice", 2)
    data object Bob: TestPerson("Bob", 3)
    data object Bob2: TestPerson("Bob2", 4)
    data object Bob3: TestPerson("Bob3", 5)

    companion object {
        val fakePersons = mapOf(
            "Alice1" to Alice1,
            "Alice" to Alice,
            "Bob" to Bob,
            "Bob2" to Bob2,
            "Bob3" to Bob3,
        )
    }
}