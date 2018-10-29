// https://kotlinlang.org/docs/reference/generics.html
class GenericExample<T> {

    fun test01(value: T) {
        println("This is a value $value")
    }

}

fun main(args: Array<String>) {
    val genInt = GenericExample<Int>()
    genInt.test01(20)

    val genString = GenericExample<String>()
    genString.test01("Veinte")
}