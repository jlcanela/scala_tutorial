object course1_1 {

    // lets start with simple expressions
    1
    1 + 1
    3 * 2
    3 + 2 * 3

    // parenthesis is 
    (3 + 2) * 3

    // challenge: how much is 7 by 7 ?

    // challenge: how much is 4 plus 3 multiply by 3 * 2 ?

    // Reference "Precedence of operators": https://docs.scala-lang.org/tour/operators.html
}

object course1_2 {
    
    // Let’s define variables

    var a = 1
    a = 2
    // error: a = "a"
    
    var aFloat = 1.0
    var aFloat2 = 1.0f
    var aDouble = 1.0d
    var anInt = 0xff
    
    // A value cannot be changed
    val anInt = 1
    // error: a = 2

    val i: Int = 1
    val number: Long = 1000000000
    val pi: Double = 3.14159

    // For common types, associated object provides additional information / capabilities
    Long.MaxValue
    Double.MinValue

    // String is an important type    
    val s: String = "Hello World !"
    val firstName: String = "John"
    val lastName: String = "Smith"

    // String interpolation allow one to compose strings in a meaningful way
    val helloJohnSmith: String = s"Hello ${firstName} ${lastName} !"

    // A tuple enable multiple types composition
    val tuple = (1, "Hello World")
    tuple._1
    tuple._2

    // challenge: define 'nbElements' a value of 1,000,000,000 with the smaller type
    // challenge: define 'nbStars' a value of Math.pow(10, 300) with the smaller type
    // challenge: explain for each numerical type why it is possible or not possible to represent Math.pow(10, 100000)
    // challenge: given the value tuple=(23, "Adam") how would you prepare the message 'The age of Adam is 23' ?

}

object course1_3 {

    // define a function       
    def helloWorld(): String = { 
        return "Hello World !" 
    }

    // and then call it
    helloWorld()

    // a block between {} is an expression
    // "return" keyword is not necessary
    def helloWorld() = { 
        "Hello World !" 
    }

    // a function can be a value
    def helloWorld() = "Hello World !"

    // a function can have multiple parameters
    def add(x: Int, y: Int): Int = { 
        return x + y 
    }
    add(1, 1)

    // a function have a return type, it is inferred by default when not present
    def add(x: Int, y: Int) = x + y 
    
    val addOne = add(_, 1)

    // CAUTION: more examples, to develop
    // replace 1 or more parameters
    // partial application - add(1, _)
    // when the "_" can replace a parameter, it allows transforming a function into a value
    val functionAsValue = add(_, _)

    // tupling allow transforming a function add(x: Int, y: Int) into a function add(tuple: (x: Int, y: Int))
    // example of a fufnciont with two parameters vs a function of single param
    // but they are different. 
    // similar but not to use in the same cases
    // extra layer of parenthessi
    val tupledAdd = functionAsValue.tupled
    val aTuple = (2, 3)
    val five = tupledAdd(aTuple)

    
    
    // it’s possible to assign an anonymous function to a value
    val anonymousFunction = (x: Int, y: Int) => x + y
    
    // challenge: define a muldiv function to multiply x: Int by num: Int and divide by denum: Int, 
    // share the function 
    // how much is mul(506,12,132) ?

    // challenge: reusing function muldiv create a value of function byFourThird(x: Int): Int to multiply by 4/3" 

    // challenge: create a function extractFirstNameAndLastName to extract firstname & lastname
    // what should be the return type of the function ?
    // use this function to get firstname and lastname from value "John Smith"
    // you can use for example the following code : 
    // val Array(firstname, lastname) = "John Smith".split(" ") 

    // "there are two ways to represent, function which return a function ~ function with multiple params ..."
    // (x: Int, y: Int) => Int
    // (x: Int) => ((y: Int) => Int)
    // both functions are equivalent ! 

}

object course1_4_control_structures {

    // a simple value
    val a1 = 1

    // assign result of block execution to a value
    val a2 = { 
        1 
    } 

    // a block can be arbitrarily complex
    val b = { 
        val bb = 1;
        bb + 1 
    }

    def f(i: Int) = i + 1

    val c = { 
        val cc = 1;
        cc + f(1) 
    }

    // if else
    val num = 2
    if ((num % 2) == 0) { 
        println("odd") 
    } else { 
        println("even") 
    }

    // if else is an expression
    def isEven(num: Int) = if (num % 2 == 1) { 
        true 
    } else { 
        false 
    }

    // while loop
    var index = 0
    do { 
        println(index)
        index += 1 
    } while(index < 10)

    // for loop
    for(i <- 1 to 10) println(i)

    // more complex for loop    
    for(i <- 1 to 10) { 
        val message = s"i=$i"; println(message)
    }

    // for yield is a way to transform collections
    val indices = for(i <- 1 to 10) yield i * 2

    val cities = Array("Tokyo-Yokohama" -> "37,843,000", "Jakarta" -> "30,539,000")  
    
    var index = 0
    do { 
        val name = cities(index)._1
        val population = cities(index)._2
        println(s"population of ${name} is ${population}")
        index += 1 
    } while (index < cities.length)


    // challenge: returns the name of the city having the max population
    // you can use two variables, name and max_population,
    // and update them if the current city population is greater than max_population 
    // var name = ""
    // var max_population = 0
    def cityHavingMaxPopulation(cities: Array[(String, String)]): String = ??? // challenge: implement this function

    // challenge: using internet find the data of the 20 biggest cities, 
    // ensure the function cityHavingMaxPopulation returns the right value

}

object course1_5_classes {

    case class Person(firstName: String, lastName: String, age: Int)
    val p = Person("John", "Doe", 23)
    println(s"firstname: ${p.firstName}")

    // challenge implement fromString function in Person compagnon object
    object Person { 
        def fromString(s: String): Person = ??? 
        val defaultPerson = Person("John", "Doe", 33)
    }

    trait People {
        def firstName: String
        def lastName: String
        def age: Int
    }

    case class Person2(firstName: String, lastName: String, age: Int) extends People

    // why is the Person3 case class cannot extend People
    case class Person3(firstName: String, lastName: String) extends People

    // the copy operator, equals / hashcode, toString + constructor / distructor 
    
    // the copy operator
    val john = Person("John", "Doe", 33)
    val jane = john.copy(firstName = "Jane", age = 31)

    // for non case classes
    class SimplePerson(firstName: String, lastName: String) 
    val j1 = new SimplePerson("John", "Doe")
    val j2 = new SimplePerson("John", "Doe")
    println(j1 == j2) // false
    println(j1.equals(j2)) // false

    // for case classes
    val john1 = Person("John", "Doe", 33)
    val john2 = Person("John", "Doe", 33)
    println(j1 == j2) // true
    println(j1.equals(j2)) // true

    // for hashcode
    // hashcode in case classes is function of the values of the object
    // hashcode in non case classes is function of the instance of the object
    // even if two non case class objects have same valuses, they do not have the same hashcode
    // hashcode is used for Collections like Hashmaps

    class Service {
        def peoples: Array[People] = ???
    }


}

object pattern_matching {


    // let’s extract value from tuples
    val ((firstNameT, lastNameT), ageT)  = (("John", "Doe"), 33)

    // let’s extract values from case class
    val Person(firstNameC, lastNameC, ageC) = Person("John", "Doe", 23) 

    // it is an example of pattern matching, similar to the switch case in other languages
    // value match {
    //   case EXTRACTOR1 => expression
    //   case EXTRACTOR2 => expression
    //   ...
    //   case EXTRACTORn => expression
    //}
    
    // it works with case classes
    val johnDoe = Person("John", "Doe", 23) 
    johnDoe match {
        case Person(firstName, lastName, age) => s"firstName = ${firstName}, lastName = ${lastName}, age = ${age}"
    }

    // but also tuples
    val tupledJohn = (("John", "Doe"), 33) 
    tupledJohn match {
        case ((firstName, lastName), age) => Person(firstName, lastName, age) 
    }

    def isAdult(person: Person) = person match {
        case Person(_, _, age) if age >= 18 => true 
        case _ => false
    }

}
