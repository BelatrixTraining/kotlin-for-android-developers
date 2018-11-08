// https://medium.com/@agrawalsuneet/property-getter-and-setter-kotlin-d89a3e70e62
package gettersetter

class Animal {

    var nombre: String?
        get() = nombre ?: ""
        set(value) {
            if (value != null)
                nombre = value
        }

    var vacio: Boolean? = false
        get() = (nombre != null && nombre?.isNotEmpty()!!)
        private set

}