// Forced to override only 'getter'
val Developer.project: String
    get() = "D1"

// No Backing Fields
// Forced to override getter & setters
var Developer.fullName: String
    get() = "$name $lastName"
    set(value) {
        name = value
        lastName = ""
    }

fun main(args: Array<String>) {
    val dev = Developer("Siwis", "Paulino")
    println(dev.project)
    println(dev.fullName)

    dev.fullName = "Holi boli"

    println(dev.fullName)
}





