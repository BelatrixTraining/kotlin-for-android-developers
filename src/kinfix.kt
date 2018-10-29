// 1. Debe ser función o extensión
// 2. Sólo un parámetro
// 3. Tipo unico parámetro y no valor por defecto

infix fun Int.myShl(x: Int): Int {
    println("X value is $x")
    return x * this
}

fun testInfix() {
    // calling the function using the infix notation
    println(1 myShl 7)

    // is the same as
    println(4.myShl(2))
}

fun main(args: Array<String>) {
    testInfix()
}