import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    testSimpleNullCheck(null)
    testSimpleNullCheck("123")

    println("**********************************************")

    testSimpleNullCheckWithSomeRandomMutableValueMultiThreads()
}

fun testSimpleNullCheck(x: String?) {
    if (x != null) {
        println("Haha, I am not null, gonna use the not null assertion operator here!")

        val y: Int = x.length + 10

        println(y)
    } else {
        println("Hey there!, I am null :D")
    }
}

var someRandomValue: String? = null

// Intentionally commented out
/*fun testSimpleNullCheckWithSomeRandomMutableValue() {
    if (someRandomValue != null) {
        println("Haha, I am not null, gonna use the not null assertion operator here!")

        val y: Int = someRandomValue.length + 10

        println(y)
    } else {
        println("Hey there!, I am null :D")
    }
}*/

fun testSimpleNullCheckWithSomeRandomMutableValueMultiThreads() {
    someRandomValue = "12345"

    val executor = Executors.newSingleThreadScheduledExecutor()

    executor.schedule({
        someRandomValue = null
    }, 1000, TimeUnit.MILLISECONDS)

    if (someRandomValue != null) {
        println("I am not null, but gonna check this again after 2 secs, just in case :)")

        Thread.sleep(2000)

        if (someRandomValue != null) {
            println("This sounds reasonable right?")
        } else {
            println("Not this time, I am null now ;)")
        }
    } else {
        println("Hey there!, I am null :D")
    }
}