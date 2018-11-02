fun main(args: Array<String>) {
    testUsefulStringExtensions("Hola papá")
    testUsefulStringExtensions("")
    testUsefulStringExtensions(null)
    testUsefulStringExtensions("                             ")
}

fun testUsefulStringExtensions(s: String?) {
    println("Let's evaluate $s ;)")
    println("Is s null or empty? -> ${s.isNullOrEmpty()}")
    println("Is s null or blank? -> ${s.isNullOrBlank()}")
    println("Is s not blank? -> ${s?.isNotBlank()}")
    println("Is s not empty? -> ${s?.isNotEmpty()}")
}

/**
 * Psdt: Goodbye mBanking StringUtils class :D
 *
 */