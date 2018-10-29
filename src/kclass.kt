open class Mascota {

    open fun ladrar() = println("Wow")

}

class Bobby : Mascota() {
    override fun ladrar() {
        println("Bau bau bau bau")
    }
}

fun main(args: Array<String>) {
    val mascota = Mascota()
    mascota.ladrar()

    val bobby = Bobby()
    bobby.ladrar()
}