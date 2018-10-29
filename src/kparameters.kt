class Parameters01 {

    fun hello() {
        println("Hello Bobby!!!")
    }

    // Explicit return
    fun sum(x: Int = 0, y: Int = 0): Int {
        return x + y
    }

    // Single-Expression
    fun sum2(x: Int = 0, y: Int = 0): Int = x + y

}

fun main(args: Array<String>) {
    val e1 = Parameters01()
    e1.hello()

    println(e1.sum(x = 5, y = 7))
    println(e1.sum(x = 2))
    println(e1.sum(y = 4))
    println(e1.sum())

    println(e1.sum2(x = 5, y = 7))

    val mascota = Mascota()
    mascota.ladrar()

    val bobby = Bobby()
    bobby.ladrar()
}