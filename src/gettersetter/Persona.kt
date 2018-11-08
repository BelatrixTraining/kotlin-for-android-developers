package gettersetter

open class Persona {
    var nombre: String? = null
    var apellido: String? = null

    // Ejemplo redundante
    var direccion: String? = null
        get() = field
        set(value) {
            field = value
        }

    var nombreCompleto: String
        get() {
            return "$nombre $apellido"
        }
        set(value) {
            val array = value.split(" ".toRegex())
            nombre = array[0]
            apellido = array[1]
        }

    open var edad: Int? = 5
        get() = 20

}