// Named arguments
fun paramLambda01(x: Double, y: Float = 0.0f, callback: Unit? = null) {
    // callback
    callback.run {
        println("Test 1 : X is $x and Y is $y")
    }
}

fun paramLambda02(x: Double, y: Float = 0.0f, callback: () -> Unit = {}) {
    callback.invoke()
    callback.run {
        println("Test 2 : X is $x and Y is $y")
    }
}

fun paramLambdaTest01() {
    println("Run bobby Run")
}

fun main(args: Array<String>) {
    paramLambda01(x = 7.0)
    paramLambda01(x = 0.0, callback = paramLambdaTest01())
    paramLambda02(x = 5.0)
    paramLambda02(x = 5.0, y = 7.0f) { println("Running!") }
}