# kotlin-for-android-developers
Course - Android for Android Developers

### -------

## Temary 

- Lesson 1 : Kotlin fundamentals
- Lesson 2 : Comparison to Java
- Lesson 3 : Functions and Lambdas
- Lesson 4 : Interoperability with java
- Lesson 5 : Null Safety
- Lesson 6 : Android Components with Kotlin
- Lesson 7 : Extensions
- **Lesson 8 : Modular applications using Kotlin**

## Kotlin for Server Side "knotes"

- Spring boot 

https://start.spring.io/

https://spring.io/guides/tutorials/spring-boot-kotlin/

https://kotlinlang.org/docs/tutorials/spring-boot-restful.html

https://github.com/JetBrains/kotlin-examples/tree/master/tutorials/spring-boot-restful

- Heroku

https://devcenter.heroku.com/articles/getting-started-with-kotlin

- MLab Mongodb

https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb

https://spring.io/guides/gs/accessing-data-mongodb/

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-nosql.html

https://mlab.com/

```
mongo dsXXXXXX.mlab.com:17495/notes -u <dbuser> -p <dbpassword>

mongodb://<dbuser>:<dbpassword>@dsXXXXXX.mlab.com:17495/notes
```

```
mongodb://<username>:<password>@dsXXXXXX.mlab.com:17495/<table>
```

resources/application.properties
```
spring.data.mongodb.uri=mongodb://<username>:<password>@dsXXXXXX.mlab.com:17495/<table>
```

Commands

```
./gradlew clean build
```

Run local
```
./gradlew bootRun
```

```
heroku local web
```

```
http://localhost:5000/
```

- EndPoints

	https://agile-scrubland-67451.herokuapp.com/

	https://agile-scrubland-67451.herokuapp.com/api/notes

	https://agile-scrubland-67451.herokuapp.com/api/users

	Add user (POST)

	https://agile-scrubland-67451.herokuapp.com/api/user

	{
	    "username":"kotlin1@admin.com",
	    "password":"123456",
	    "firstname": "Kotlin",
	    "lastname": "Kotlin"
	}


## Modular App

### packages

- com.kotlin.samples.kotlinapp
- com.kotlin.samples.kotlinapp.modules
- com.kotlin.samples.kotlinapp.modules.authentication

- com.kotlin.samples.kotlinapp.modules.mymodule

Crear módulo

```
settings.gradle
```

```
include ':app', ':kmymodule'
```

```
implementation project(":kmymodule")
```

Crear módulos independientes 

Creamos un nuevo proyecto

com.kotlin.samples.kotlinapp.modules.kauthentication

Reemplazar

apply from: '../knotes.gradle'


Android Maven Gradle Plugin

https://github.com/dcendents/android-maven-gradle-plugin

```
buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath 'com.github.dcendents:android-maven-gradle-plugin:2.1'
	}
}

apply plugin: 'com.android.library'
apply plugin: 'com.github.dcendents.android-maven'
```

```
group = "com.kotlin.samples.kotlinapp.modules"
archivesBaseName = "kauthentication"
version = "1.0.0"
```

Agregar un módulo

```
kauthentication-ui
com.kotlin.samples.modules.kauthentication.ui
```

```
include ':app', ':kauthenticationui'
```

Agregar plugins

```
apply plugin: 'com.android.library'
apply plugin: 'com.github.dcendents.android-maven'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
```

```
group = "com.kotlin.samples.modules"
archivesBaseName = "kauthentication-ui"
version = "1.0.0"
```

```
./gradlew install
```

- .m2/
	- repository/
	- com.kotlin.samples.modules/
	- kauthentication-ui/
	- 1.0.0/

Notes module

```
knotesui
com.kotlin.samples.modules.knotes.ui
```

```
group = "com.kotlin.samples.modules"
archivesBaseName = "knotes-ui"
version = "1.0.0"
```

```
./gradlew install
```

Core module

Creamos el proyecto

```
kcore
com.kotlin.samples.modules.kcore
```

Agregamos el módulo

```
kcoresupport
com.kotlin.samples.modules.kcoresupport
```

```
group = "com.kotlin.samples.modules"
archivesBaseName = "kcore-support"
version = "1.0.0"
```

Dashboard module

Agregamos el proyecto "kdashboard"

```
kdashboard
com.kotlin.samples.modules.kdashboard
```

Agregamos el module "kdashboardui"

```
com.kotlin.samples.modules.kdashboardui
```

```
group = "com.kotlin.samples.modules"
archivesBaseName = "kdashboard-ui"
version = "1.0.0"
```

### Dependencias

```
   mavenLocal()
```

```
   implementation "com.kotlin.samples.modules:kcore-support:1.0.0"
```

### modules

- knotes.gradle
- kcore/
- kapp/
- kauthentication/
	- ui
	- data

- knotes/
	- ui
	- data
- kfeaturea/
- kfeatureb/


Agregamos las dependencias

```
  api "com.kotlin.samples.modules:kcore-support:1.0.0"

    implementation "com.kotlin.samples.modules:kauthentication-ui:1.0.0"
    implementation "com.kotlin.samples.modules:kdashboard-ui:1.0.0"
```

Commands

```
./gradlew clean install
```

## References 

- Kotlin programming language https://kotlinlang.org/
- Develop Android apps with Kotlin https://developer.android.com/kotlin/
- Kotlin offical documentation https://kotlinlang.org/docs/reference/
- CodeLabs https://codelabs.developers.google.com/

- RESTFul Web https://kotlinlang.org/docs/tutorials/spring-boot-restful.html

- Kotlin Conf app https://github.com/JetBrains/kotlinconf-app
