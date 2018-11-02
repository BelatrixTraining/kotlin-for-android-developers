fun main(args: Array<String>) {
    val nullTeam = null
    val riverPlate = Team("River Plate", Division.B)

    soYouWannaGetNullPointerException(riverPlate)
    soYouWannaBeTheMasterOfNullSafety(riverPlate)

    println("***********************************************")

    soYouWannaGetNullPointerException(nullTeam)
    soYouWannaBeTheMasterOfNullSafety(nullTeam)
}

enum class Division {
    A, B
}

class Team(val name: String, var division: Division) {

    fun play() {
        println("$name -> Estamos en la ${division.name}")
    }
}

fun soYouWannaGetNullPointerException(team: Team?) {
    try {
        team!!.play()
    } catch (exception: NullPointerException) {
        println("Oh damn it :(")
    }
}

fun soYouWannaBeTheMasterOfNullSafety(team: Team?) {
    team?.play()
}