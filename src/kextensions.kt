// https://kotlinlang.org/docs/reference/extensions.html
class ExtensionClass {
    fun run() {
        println("member")
    }
}

fun ExtensionClass.run(i: Int) {
    println("extension $i")
}

fun ExtensionClass.belatrix() {
    println("Hoy es fiesta de HALLOWEEN!!!!")
}

fun verTexto(str: String) {
    println("Este es un texto $str")
}

fun main(args: Array<String>) {
    val ext = ExtensionClass()
    ext.run()
    ext.run(7)
    ext.belatrix()
}