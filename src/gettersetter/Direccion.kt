// https://kotlinlang.org/docs/reference/properties.html
package gettersetter

class Direccion {
    var nombre: String? = null
    var calle: String? = null
    var ciudad: String? = null
    var estado: String? = null

    // var error:Int? // Esto genera error porque debe ser iniciado

    fun copiarDireccion(dir: Direccion): Direccion {
        val direccion = Direccion()
        direccion.calle = dir.calle
        return direccion
    }

}