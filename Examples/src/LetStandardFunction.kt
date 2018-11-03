fun main(args: Array<String>) {
    testLetFunction1("hola papa")
    testLetFunction1(null)

    println("***********************************************")

    testLetFunction2("hola papa")
    testLetFunction2(null)
}

fun testLetFunction1(x: String?) {
    val y = x?.let {
        return@let "X is not null"
    } ?: "X is null"

    println(y)
}

fun testLetFunction2(x: String?) {
    x.let {
        println("x is $it")
    }
}