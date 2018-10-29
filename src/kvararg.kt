// Ejemplo basado de la página de Kotlin

fun multiplesArgument(vararg params: String) {
    params.forEach {
        println(it)
    }
}

fun main(args: Array<String>) {
    multiplesArgument(
            params = *arrayOf("dat", "bobby", "works", "a", "lot", "gg")
    )
}