object CompanionClass {

    fun doSomething() {
        println("doing something :D")
    }
}

fun CompanionClass.doSomethingElse() {
    println("doing something else :D")
}

class CommonClass {

    companion object {
        fun doSomething() {
            println("doing something :D")
        }
    }
}

fun CommonClass.doSomethingElse() {
    println("do something else :D")
}

fun CommonClass.Companion.doSomethingElse() {
    println("do something else v2 :D")
}

fun main(args: Array<String>) {
    CompanionClass.doSomething()
    CompanionClass.doSomethingElse()

    println("*******************")

    CommonClass.doSomething()
    CommonClass.doSomethingElse()

    val x = CommonClass()
    x.doSomethingElse()
}
