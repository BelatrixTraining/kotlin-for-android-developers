fun main(args: Array<String>) {
    testRunFunction1()

    println("****************************************")

    testRunFunction2(Developer("Siwis"))

    println("*****************************************")

    testRunFunction3(null)
}

fun testRunFunction1() {
    val x = run {
        Developer("Siwis")
    }

    println(x.name)
}

fun testRunFunction2(x: Developer?) {
    val qa: QA? = x?.run {
        this.project = "FIS"
        QA("QAsiwis")
    }

    println("${x?.project} ${qa?.name}")
}

fun testRunFunction3(x: Developer?) {
    x?.let {
        // Do something
    } ?: run {
        println("x is null")

        // Do something else
    }
}