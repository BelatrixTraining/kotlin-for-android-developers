/****************************************************************/

class Developer(var name: String?) {
    var lastName: String? = null
    var project: String? = null
    var alias: String? = null
}

data class QA(var name: String?)

/****************************************************************/

enum class Division {
    A, B
}

class Team(val name: String, var division: Division) {

    fun play() {
        println("$name -> Estamos en la ${division.name}")
    }
}

/****************************************************************/

var randomString: String? = null