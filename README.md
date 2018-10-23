# Lesson 2 - Comparison to Java
# Thursday, October 25, 2018

## Topics
* **General Differences**
* **Java Class vs Kotlin Class**
    * Boilerplate code
* **Java Types vs Kotlin Types**
    * Inferred Types
    * Type Checks
    * Smart Casts
* **Null Safety** (We will see this in detail in a another class)
* **Interoperability** (We will see this in detail in another class)

### General Differences
1. In Kotlin functions and variables not necessarily are part of a class.
1. Semicolon is not used at the end of a sentence.

### Java Class vs Kotlin Class
There are some differences between a class created in Java with a class created in Kotlin:
1. **new** keyword is not used to instantiate an object of a class.
1. In Kotlin classes are closed by default, that means that the class cannot be extended. To be able to extend
from a class this should be declared as **open** class. **abstract** classes are open by default.
1. Properties are declared in the class constructor.
1. In Kotlin a default value for each attribute can be defined.
1. In Kotlin getters and setters are not necessary, so, the language reduces a lot of Boilerplate code that Java adds to a class.
But Getters and Setter can also be defined in Kotlin.
1. A Kotlin class can be defined in a single line.
1. A class can have multiple constructors declared using the word **constructor**
1. Data classes are used to define POJOs, it has to be declared with the **data** key word and all properties
should be declared in the constructor. toString, hashcode and equals methods are defined by default in a data class.

#### Java Class
```
public class Person {
    private String name;
    private Integer age;

    public Person(){
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }
}
```
#### Kotlin Class
```
open class Person (val name: String, val age: Int)
class Developer(val name: String): Person(name, 20) // In this case a Developer is a Person and its age is 20 by default.
```

## References
* Kotlin Site: https://kotlinlang.org/docs/reference/
* Android Developers: https://developer.android.com/kotlin/
* Kotlin for Android Developers - Antonio Leiva