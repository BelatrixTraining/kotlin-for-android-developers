
fun Employee.work() {
    println("work work work work work work :D")
}

fun Developer.work() {
    println("code code code code code code :D")
}

fun QA.work() {
    println("test test test test test test :D")
}

fun whatever(employee: Employee) {
    employee.work()
}

fun whateverAsDev(developer: Developer) {
    developer.work()
}

fun whateverAsQA(qa: QA) {
    qa.work()
}

fun main(args: Array<String>) {
    whatever(Developer("Siwis", "Paulino"))
    whatever(QA("Elsa", "Capunta"))
    whateverAsDev(Developer("Siwis", "Paulino"))
    whateverAsQA(QA("Zoila", "Mesa"))
}