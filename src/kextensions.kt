// https://kotlinlang.org/docs/reference/extensions.html
class ExtensionClass {
    fun run() {
        println("member")
    }
}

fun ExtensionClass.run(i: Int) {
    println("extension $i")
}