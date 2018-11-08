// https://kotlinlang.org/docs/reference/lambdas.html
// https://try.kotlinlang.org/#/Kotlin%20Koans/Collections

fun foldExample() {
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas are code blocks enclosed in curly braces.
    items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
        acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }
}

fun filterExample() {
    println()
    println("Filter Example")
    val items = listOf(1, 2, 3, 4, 5)

    println(items)
    items.filter { it % 2 != 0 }.forEach {
        println("\t$it")
        // Customer it.name, it.lastName
    }
    println()
    println()
}

fun mapExample() {
    val numbers = listOf(1, -1, 2)
    println(numbers.filter { it > 0 })
    println(numbers.map { it * it })
}

fun example01() {
    println()
    val names = arrayOf("Carlos", "Raul", "Andres", "Sergio", "Kausha", "Fufi", "Santilli", "Saoco")

    val name = names
            .filter { name -> name.startsWith("z", ignoreCase = true) }
            .sortedBy { name -> name.length }
            .firstOrNull()

    println(name)
}

fun main(args: Array<String>) {
    foldExample()
    filterExample()
    mapExample()
    example01()
}