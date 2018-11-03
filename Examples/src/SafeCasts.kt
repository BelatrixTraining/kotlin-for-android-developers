fun main(args: Array<String>) {
    val dev = Developer("Gunnaringumu Diminson, Yugunothwer Misinjawer")
    val qa = QA("Ckipther Alewphawer Yacunah, Zumac Yaxche")

    soYouWannaGetClassCastException(dev)
    soYouWannaGetClassCastException(qa)

    println("*******************************************************")

    soYouWannaBeTheMasterOfClassCasting2018ForeverSingle(dev)
    soYouWannaBeTheMasterOfClassCasting2018ForeverSingle(qa)
}

fun soYouWannaGetClassCastException(anyone: Any) {
    try {
        println((anyone as Developer).name)
    } catch (exception: ClassCastException) {
        println("oh damn it! :(")
    }
}

fun soYouWannaBeTheMasterOfClassCasting2018ForeverSingle(anyone: Any) {
    println((anyone as? Developer)?.name ?: "nothing to show, you are not a developer :)")
}