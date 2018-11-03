fun main(args: Array<String>) {
    val nullTeam = null
    val riverPlate = Team("River Plate", Division.B)

    soYouWannaGetNullPointerException(riverPlate)
    soYouWannaBeTheMasterOfNullSafety(riverPlate)

    println("***********************************************")

    soYouWannaGetNullPointerException(nullTeam)
    soYouWannaBeTheMasterOfNullSafety(nullTeam)
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