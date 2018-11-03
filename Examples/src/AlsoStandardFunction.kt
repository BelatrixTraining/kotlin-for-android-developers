fun main(args: Array<String>) {
    testAlsoFunction1(Developer("Siwis"))

    println("*********************************************")

    testAlsoFunction2()
}

fun testAlsoFunction1(x: Developer?) {
    val y = x?.also {
        it.name = "Changing developer's name"
    }

    println(y?.name)
}

fun testAlsoFunction2() {
    val y = Developer("Alonso").also { it.lastName = "Paulino" }

    println("${y.name} ${y.lastName}")
}