open class FIS {
    open fun Employee.eat() {
        println("Employee.eat in FIS class")
    }

    open fun Developer.eat() {
        println("Developer.eat in FIS class")
    }

    fun whatever(employee: Employee) {
        employee.eat()
    }
}

class FISMobile : FIS() {
    override fun Employee.eat() {
        println("Employee.eat in FISMobile")
    }

    override fun Developer.eat() {
        println("Developer.eat in FISMobile")
    }
}

fun main(args: Array<String>) {
    FIS().whatever(Employee("Siwis", "Paulino"))
    FISMobile().whatever((Employee("Siwis", "Paulino")))
    FIS().whatever(Developer("Siwis", "Paulino"))
}