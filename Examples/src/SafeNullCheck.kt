import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    testSafeNullCheckWithSomeRandomMutableValueMultiThreads()
}

fun testSafeNullCheckWithSomeRandomMutableValueMultiThreads() {
    randomString = "12345"

    val executor = Executors.newSingleThreadScheduledExecutor()

    executor.schedule({
        randomString = null
    }, 1000, TimeUnit.MILLISECONDS)

    randomString?.let { value ->
        println("I am not null, but gonna check this again after 2 secs, just in case :)")

        Thread.sleep(2000)

        println(value) // Value is immutable, never won't be null inside this block
    }
}

