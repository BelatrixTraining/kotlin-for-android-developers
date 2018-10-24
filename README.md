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

### Overview
Slide https://docs.google.com/presentation/d/16VH_Q2BL_sYr4yboAFf32_26w8LqRniHtTt8d4ZvluQ/edit?usp=sharing

### General Differences
1. Kotlin is an OOP language and also is oriented to be a functional language, so methods in Java are functions in Kotlin.
1. In Kotlin functions and variables not necessarily are part of a class.
1. Semicolon is not used at the end of a sentence.
1. **extends** and **implements** keyword are not used for inheritance, : is used for this.
1. @Override is replaced by **override**

### Java Class vs Kotlin Class
There are some differences between a class created in Java with a class created in Kotlin:
1. **new** keyword is not used to instantiate an object of a class.
1. In Kotlin classes are closed by default, that means that the class cannot be extended. To be able to extend
from a class this should be declared as **open** class. **abstract** classes are open by default.
1. Properties are declared in the class constructor.
1. In Kotlin a default value for each attribute can be defined.
1. In Kotlin getters and setters are not necessary, so, the language reduces a lot of Boilerplate code that Java adds to a class.
But Getters and Setter can also be defined in Kotlin. val allows only get, var allows get and set.
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

### Java Types vs Kotlin Types
An interesting thing from Kotlin is that most of the time you won’t need to specify the type of the objects you are working with, 
as long as the compiler can infer it.
So we just need to write **var** or **val** depending on the type of variable we want to generate, even though you can always 
specify a type explicitily.
In Kotlin everything is an object, there are no basic types and there is no **void** that is represented by **Unit**. 

#### Some examples
```
var x = 7 // x is an Int
vay y = "My String" // y is an String
```

#### Type Checks
In java we check the type using **instanceof**, Kotlin uses **is** or its negated form **!is**

```
// Checks if obj is a String.
if (obj is String) {
    print(obj.length)
}

// Checks if obj is not a String
if (obj !is String) { // same as !(obj is String)
    print("Not a String")
} else {
    print(obj.length)
}
```

#### Smart Casts
In some cases explicit casts are not needed in Kotlin:

1. The compiler tracks is-checks and add safe casts automatically:
```
fun demo(x: Any) {
    if (x is String) {
        print(x.length) // x is automatically cast to String
    }
}
```

1. if a negative check leads to a return:
```
if (x !is String) return
    print(x.length) // x is automatically cast to String
```

1. In the right-hand side of && and ||:
```
// x is automatically cast to string on the right-hand side of `||`
    if (x !is String || x.length == 0) return

    // x is automatically cast to string on the right-hand side of `&&`
    if (x is String && x.length > 0) {
        print(x.length) // x is automatically cast to String
    }
```

1. Smart casts work also for when expressions: 
```
when (x) {
       is Int -> print(x + 1)
       is String -> print(x.length + 1)
       is IntArray -> print(x.sum())
   }
```

#### Unsafe Cast Operation
Usually, the cast operator throws an exception if the cast is not possible. 
Thus, we call it unsafe. The unsafe cast in Kotlin is done by the infix operator **as**
```
val x: String = y as String

// nullable
val x: String? = y as? String
```

## References
* Kotlin Site: https://kotlinlang.org/docs/reference/
* Android Developers: https://developer.android.com/kotlin/
* Kotlin for Android Developers - Antonio Leiva