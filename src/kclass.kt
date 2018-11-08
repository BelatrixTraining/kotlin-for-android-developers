open class Mascota {

    open fun ladrar() {
        println("Wow")
    }

    open fun run() {
        println("Running the application.")
    }

}

class Bobby : Mascota() {
    override fun ladrar() {
        println("Bau bau bau bau")
    }

    override fun run() {
        println("Running Bobby Application")
    }
}

fun main(args: Array<String>) {
    val mascota = Mascota()
    mascota.ladrar()
    mascota.run()

    println()

    val bobby = Bobby()
    bobby.ladrar()
    bobby.run()

    verTexto("EduEduEdu")
}