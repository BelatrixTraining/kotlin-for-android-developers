// https://kotlinlang.org/docs/reference/inline-functions.html
// Formas de evitar el uso excesivo de memoria.
// Básicamente copia funciones y parámetros a forma local.
// https://www.quora.com/When-do-we-use-inline-function

inline fun inlineTest(a: Int, callback: () -> Unit): Int {
    callback()
    return 7 * a
}

fun main(args: Array<String>) {
    var myValue = 10
    println(inlineTest(myValue) { println("Returning something casually here") })
}

/*
So basically inline can be used when we wish to reduce memory overhead.
But inline also increases the resulting bytecode. Which is why,
inline usage should be avoided with large functions or accessors with large code logic.
 */