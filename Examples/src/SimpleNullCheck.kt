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

// Intentionally commented out
/*fun testSimpleNullCheckWithSomeRandomMutableValue() {
    if (randomString != null) {
        println("Haha, I am not null, gonna use the not null assertion operator here!")

        val y: Int = randomString.length + 10

        println(y)
    } else {
        println("Hey there!, I am null :D")
    }
}*/

fun testSimpleNullCheckWithSomeRandomMutableValueMultiThreads() {
    randomString = "12345"

    val executor = Executors.newSingleThreadScheduledExecutor()

    executor.schedule({
        randomString = null
    }, 1000, TimeUnit.MILLISECONDS)

    if (randomString != null) {
        println("I am not null, but let's print this value after 2 secs :)")

        Thread.sleep(2000)

        println(randomString ?: "I am null. (whaaaaat?)")
    } else {
        println("Hey there!, I am null :D")
    }
}