open class Employee(var name: String, var lastName: String)

class Developer(name: String, lastName: String): Employee(name, lastName)

class QA(name: String, lastName: String): Employee(name, lastName)