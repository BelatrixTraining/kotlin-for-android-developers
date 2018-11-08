/*
    A lambda expression or anonymous function
    (as well as a local function and an object expression)
    can access its closure, i.e. the variables declared in
    the outer scope. Unlike Java, the variables captured in
    the closure can be modified.
 */
fun main(args: Array<String>) {
    var sum = 0
    val ints = listOf(1, 2, 3, 4, 5)
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)

}