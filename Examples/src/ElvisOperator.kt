fun main(args: Array<String>) {
    testElvisOperator()

    testIfNullExpression(1)

    testIfNullExpression(null)
}

data class Dev(var name: String?)

fun testElvisOperator() {
    val androidDev = Dev("Siwis")
    val iosDev = Dev(null)

    println("androidDev's name is ${androidDev.name ?: "null 100% real no fake"}")
    println("iosDev's name is ${iosDev.name ?: "null 100% real no fake"}")
}

// Sum if op is not null, subtract if op is null
fun testIfNullExpression(op: Int?) {
    val x = 20
    val y = 20

    val result = if (op == null) x - y else x + y

    println("op is ${op ?: "null 100% real no fake"}, then result is $result")
}

