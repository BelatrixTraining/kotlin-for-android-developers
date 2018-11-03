fun main(args: Array<String>) {
    val x = Developer("Alonso")
    val y = Developer("Carlos")
    val z = Developer("Eduardo")

    val s1 = with(x) {
        lastName = "Paulino"
        project = "mBanking"
        alias = "Siwis"

        "$name $lastName - $alias - $project"
    }

    val s2 = with(y) {
        lastName = "Piñan"
        project = "mBanking"
        alias = "Bobby"

        "$name - bau bau"
    }

    val s3 = with(z) {
        lastName = "Medina"
        project = "mBanking"
        alias = "Edu"

        "$name - no me gustan las librerias, EXCEPTO Retrofit, Gson, Glide, Piccasso, Butterknife, OkHttp, Rx, etc, etc, etc"
    }

    println(s1)
    println(s2)
    println(s3)
}