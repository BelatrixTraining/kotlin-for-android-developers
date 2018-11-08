package gettersetter

class MiniPersona : Persona() {

    override var edad: Int?
        get() = 30
        set(value) {
            edad = value
        }

}