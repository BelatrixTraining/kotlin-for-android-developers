fun main(args: Array<String>) {
    testApplyFunction1(Developer("Siwis"))

    println("******************************************")

    testApplyFunction2()
}

fun testApplyFunction1(x: Developer?) {
    val y = x?.apply {
        name = "Changing developer's name"
    }

    println(y?.name)
}

fun testApplyFunction2() {
    val y = Developer("Alonso").apply { lastName = "Paulino" }

    println("${y.name} ${y.lastName}")
}