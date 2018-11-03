fun main(args: Array<String>) {
    val candidate = Developer("Siwis").apply { project = "mBanking" }

    var dev: Developer?

    dev = candidate.takeIf {
        it.project == "D1"
    }

    println(dev?.name)

    println("****************************************")

    dev = candidate.takeUnless {
        it.project == "D1"
    }

    println(dev?.name)
}