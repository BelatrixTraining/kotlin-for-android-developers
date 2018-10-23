# Lesson 1 - Fundamentals
Tuesday, October 23, 2018

## Topics 

- Fundamentals ,variables, types,conditionals, loops

- Collections, Companion Object, Data Class

- Classes, Inheritance, Interfaces, Object

## ---

## Overview

Slide https://docs.google.com/presentation/d/1AsYR8CfSQprW0SP5S-19kuREeD88_F8yB-quibEo3DM/edit?usp=sharing

## Instalation

Kotlin ya viene integrado a Android Studio(>=3.0) e Intellij IDEA

Command Line Compiler https://kotlinlang.org/docs/tutorials/command-line.html

```
kotlin -version
```
output 
```
Kotlin version 1.2.51-release-125 (JRE 1.8.0_191-b12)
```

RPEL (Interactive shell)
```
kotlinc-jvm
Welcome to Kotlin version 1.2.51 (JRE 1.8.0_191-b12)

>>> println("Welcome to the Kotlin shell")
Welcome to the Kotlin shell
```
* Usar el commando **:quit** para salir 


## Kotlin Language

Usemos **Kotlin Playground** para jugar con Kotlin y compilar en linea https://play.kotlinlang.org/

*Compilador en linea para Java https://www.compilejava.net/*

- Hello World

```kotlin
fun main(args:Array<String>){
    println("Hello Kotlin !")
}
```

output
```
Hello Kotlin !
```

- Functions

```kotlin
fun showMessage(message: String): Unit {                               
    println(message)
}
```

```kotlin
fun showMessage2(message: String){                                    
    println(message)
}
```

```kotlin
fun showMessage(message:String, param:String="Parameter"){            
    println("message : $message param : $param")
}
```

```kotlin
fun area(base:Int, height:Int):Int{                                   
    return base*height
}
```

```kotlin
fun perimeter(base:Int, height:Int)=2*base+ 2*height                 
```

```kotlin
fun main(args:Array<String>){
    showMessage("Hello Kotlin") //1
    showMessage2("Hello Kotlin") //2
    showMessage("Hello Kotlin","Leave Java")//3
    println(area(10,20)) //4
    println(perimeter(10,20)) //5

}
```

output
```
Hello Kotlin
Hello Kotlin
message : Hello Kotlin param : Leave Java
200
60
```

- Functions / vararg parameters

```kotlin
fun printWithArgs(vararg languages:String){
    for(item in languages){
        println(item)
    }
}
```

```kotlin
   printWithArgs("Java", "Kotlin", "Scala", "Groovy",
            "Clojure")
   printWithArgs("Java", "Kotlin", "C++", param = "Android")
```

output
```
Java
Kotlin
Scala
Groovy
Clojure
Android : Java
Android : Kotlin
Android : C++
```

- Variables

```kotlin
fun main(args:Array<String>){
    var language:String= "Java"

    println(language)

    language="Kotlin"

    println(language)

    val age:Int = 18

    println("Age : $age")

    val message="Kotlin for Android Developers"

    println("Message : $message")

    //message="Java for Android Developers"
}
```

output
```
Java
Kotlin
Age : 18
Message : Kotlin for Android Developers
```
- Null Safety

```kotlin
fun main(args:Array<String>){
    println("Null Safety!")

    var byeNull: String = "No puede ser null"
    //byeNull= null

    var nullable: String?="Puede ser null"
    nullable= null

    var neverNull= "No puede ser null"
    //neverNull= null

    println("byeNull : $byeNull")
    println("nullable : $nullable")
    println("neverNull : $neverNull")
}
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
```

- Working with nulls

```kotlin
fun main(args:Array<String>){
    println("Null Safety!")

    var byeNull: String = "No puede ser null"
    //byeNull= null

    var nullable: String?="Puede ser null"
    nullable= null

    var neverNull= "No puede ser null"
    //neverNull= null

    println("byeNull : $byeNull")
    println("nullable : $nullable")
    println("neverNull : $neverNull")

    //working with null

    //nullable="Esta variable no es null"

    if(nullable!=null){
        println("Not null (if) : $nullable")
    }

    println("Not null length (?) : ${ nullable?.length }")

    nullable?.let {
        println("Not null length (let) :${nullable?.length}")
    }?: run {
        println("Not null length (run) : 0")
    }
}
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null length (?) : null
Not null length (run) : 0
```

```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null (if) : Esta variable no es null
Not null length (?) : 24
Not null length (let) :24

```

- Classes

```kotlin

class Language()

class JVMLanguage(val id:Int, val name:String)

class JavaLanguage(val id:Int , var nullable:Boolean)

fun main(args:Array<String>) {
    println("Classes!")

    val language= Language()
    println("language $language")

    val jvmLanguage= JVMLanguage(0,"Kotlin")

    println("jvmLanguage $jvmLanguage")
    println("jvmLanguage ${jvmLanguage.id}  & ${jvmLanguage.name}")

    //jvmLanguage.id=1
    //jvmLanguage.name="Java"

    val javaLanguage= JavaLanguage(1,false)
    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")
    javaLanguage.nullable=true

    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")

}
```

output
```
Classes!
language Language@5e2de80c
jvmLanguage JVMLanguage@1d44bcfa
jvmLanguage 0  & Kotlin
javaLanguage 1  & false
javaLanguage 1  & true
```

- Inheritance

```kotlin
open class ObsoleteLanguage(){
    open fun sayHello() {       // 2
        println("I'm bored...")
    }
}

open class AwesomeLanguage(val message:String){
    open fun showMessage(){
        println(message)
    }
}


class JavaOLanguage:ObsoleteLanguage(){
    override fun sayHello() {
        println("I'm an obsolete language")
    }
}

class KotlinAwesomeLanguage(message:String):AwesomeLanguage(message)

fun main(args:Array<String>) {
    val obsoleteLanguage: ObsoleteLanguage = JavaOLanguage()
    obsoleteLanguage.sayHello()

    val awesomeLanguage:AwesomeLanguage= KotlinAwesomeLanguage("Kotlin is a cool language!")
    awesomeLanguage.showMessage()
}
```

output
```
I'm an obsolete language
Kotlin is a cool language!
```
---

- Control Flow

**Conditional expression**

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b         
println(max(99, -42))
```
output
```
99
```

**When** 

```kotlin
class MyClass

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")                         
        "Hello" -> println("Greeting")              
        is Long -> println("Long")                   
        !is String -> println("Not a string")        
        else -> println("Unknown")                  
    
}

fun main(args:Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}
```

output
```
Greeting
One
Long
Not a string
Unknown
```
- Loops (for, while, do-while)

**For**

```kotlin
fun main(args:Array<String>) {

    //for
    val jvmLanguages = listOf("Kotlin", "Java", "Groovy")
    for (language in jvmLanguages) {                               
        println("Jvm language : $language")
    }
}
```

output
```
Jvm language : Kotlin
Jvm language : Java
Jvm language : Groovy
```
**while**

```kolin
  //while
    var count=0
    while (count<5){
        println("count : $count")
        count++
    }
```

```
count : 0
count : 1
count : 2
count : 3
count : 4
```

**do-while**

```kotlin
    //do - while
    var i = 1
    do{
        println("item : $i")
        i++
    }while (i<5)
```

```
item : 1
item : 2
item : 3
item : 4
```

**Classes**

```kotlin
class Language()

class JVMLanguage(val id:Int, val name:String)

class JavaLanguage(val id:Int , var nullable:Boolean)

fun main(args:Array<String>) {
    println("Classes!")

    val language= Language()
    println("language $language")

    val jvmLanguage= JVMLanguage(0,"Kotlin")

    println("jvmLanguage $jvmLanguage")
    println("jvmLanguage ${jvmLanguage.id}  & ${jvmLanguage.name}")

    //jvmLanguage.id=1
    //jvmLanguage.name="Java"

    val javaLanguage= JavaLanguage(1,false)
    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")
    javaLanguage.nullable=true

    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")

}
```
output
```
Classes!
language Language@5e2de80c
jvmLanguage JVMLanguage@1d44bcfa
jvmLanguage 0  & Kotlin
javaLanguage 1  & false
javaLanguage 1  & true
```

**Data Classes**

```java
package com.kotlin.samples;

public class Customer {

    private String name;
    private String email;
    private String company;

    public Customer(String name, String email, String company) {
        this.name = name;
        this.email = email;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

```

```kotlin
data class Customer(val name: String, val email: String, val company: String)
```

**Inheritance**
```kotlin
open class ObsoleteLanguage(){
    open fun sayHello() {       // 2
        println("I'm bored...")
    }
}

open class AwesomeLanguage(val message:String){
    open fun showMessage(){
        println(message)
    }
}


class JavaOLanguage:ObsoleteLanguage(){
    override fun sayHello() {
        println("I'm an obsolete language")
    }
}

class KotlinAwesomeLanguage(message:String):AwesomeLanguage(message)

fun main(args:Array<String>) {
    val obsoleteLanguage: ObsoleteLanguage = JavaOLanguage()
    obsoleteLanguage.sayHello()

    val awesomeLanguage:AwesomeLanguage= KotlinAwesomeLanguage("Kotlin is a cool language!")
    awesomeLanguage.showMessage()
}
```

output
```
I'm an obsolete language
Kotlin is a cool language!
```


# Activities

- Verificar/Instalar versión de Kotlin
- Usar el compilador en Linea (Playground) https://play.kotlinlang.org/
- Crear un proyecto Kotlin desde Intellij IDEA
- Crear un proyecto Androd con Kotlin desde Android Studio

*Si tienes algún error de compatibilidad de kotlin con la versión de Android Studio o Gradle puede probar cambiando de versión de Kotlin*

```
    ext.kotlin_version = '1.2.50'
    //ext.kotlin_version = '1.2.41'
    //ext.kotlin_version = '1.2.61'
```

# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
- Develop Android Apps with Kotlin https://developer.android.com/kotlin/
- Getting started with Android and Kotlin https://kotlinlang.org/docs/tutorials/kotlin-android.html
- Android Developers https://developer.android.com/?hl=es-419
- Google codelabs https://codelabs.developers.google.com/
- Android Studio https://developer.android.com/studio/install
- Genymotion https://www.genymotion.com/account/create/
- Working with the Command Line compiler https://kotlinlang.org/docs/tutorials/command-line.html


