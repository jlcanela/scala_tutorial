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

object course1_6_array {
    val ages = Array(23, 21, 12, 99)
    val even = ages.filter(_ % 2 == 0)
    val message = ages.map { age => s"you have $age years"}
    message.foreach(println)
    // Map x => y

    // to document your code, use the right naming for functions
    def isEven(i: Int) = i % 2 == 0
    val evenAges = ages.filter(isEven)

    val firstNames = Array("John")
    val lastNames = Array("Doe")
    val ages2 = Array(23) 

    //  let’s reuse pattern matching inside map function
    firstNames zip lastNames zip ages2 map { 
        case ((firstName, lastName), age) => Person(firstName, lastName, age)
    }   

    val amounts = Array(4.99, 6.34, 7.99, 99.00)
    val minAmount = amounts.min
    val maxAmount = amounts.max
    val sumAmount = amounts.sum

}

object course1_6_list {

    // List    (1 + a + a^2 + a^3 + ...)
    object list_type {
        sealed trait List[A]
        object Nil extends List[Nothing]
        case class Cons[A](a: A, tail: List[A]) // ::
    }

    // lists behavior is similar to Array !

    val ages = List(23, 21, 12, 99)
    val even = ages.filter(_ % 2 == 0)
    val message = ages.map { age => s"you have $age years"}
    message.foreach(println)
    // Map x => y

    val firstNames = List("John")
    val lastNames = List("Doe")
    val ages2 = List(23) 

    firstNames zip lastNames zip ages2 map { 
        case ((firstName, lastName), age) => Person(firstName, lastName, age)
    }   

    val amounts = List(4.99, 6.34, 7.99, 99.00)
    val minAmount = amounts.min
    val maxAmount = amounts.max
    val sumAmount = amounts.sum
    // https://docs.scala-lang.org/overviews/collections/overview.html
    // Set => Unordered collection with deduplication

}

object course1_7_datatypes {

    // Option  (1 + a)
    object OptionType {

        object option_type {
            sealed trait Option[A]
            object None extends Option[Nothing]
            case class Some[A](a: A)
        }

        val anOption: Option[String] = Some("1")
        val noValue: Option[String] = None
        anOption.foreach { value =>
            println(value)
        }
        anOption.foreach(println)

        val parsedOption = anOption.map(_.toInt)
    
        def asOption(f:  => Int) = try {
            Some(f)
        } catch {
            case _: Exception => None
        }

        val nullableToOption = asOption("a".toInt)

        def addString(x: String, y: String): Option[Int] = for {
            i <- asOption(x.toInt)
            j <- asOption(y.toInt)            
        } yield i+j

        for {
            x <- List("a", "1")
            y <- List("b", "2")
        } println(s"sum of $x and $y is ${addString(x, y)}")
        
        println(addString("a", "1").map(x => s"sum is $x").getOrElse("sum is not a value"))

        def addInt(v1: Option[Int], v2: Option[Int]): Option[Int] = for {
            x1 <- v1
            x2 <- v2
        } yield x1 + x2

        val person: Person = null
        def multiplyAgeByTwo(p: Person) = p.copy(age = p.age * 2)
        multiplyAgeByTwo(person) // it will fail

        // here, I am sure to succeed
        Option(person)
        .map(multiplyAgeByTwo)
        .getOrElse(Person("John", "Doe", 0)) 

        if (person == null) {
            Person("John", "Doe", 0)
        } else {
            multiplyAgeByTwo(person)
        }

        // use Option DataType to manage missing value cases
        val person1: Person = null
        val person2 = Person("John", "Doe", 33)
        
        for {
            p1 <- Option(person1)
            p2 <- Option(person2)
        } yield Person(s"${p1.firstName} ${p2.firstName}", s"${p1.lastName} ${p2.lastName}", (p1.age + p2.age)/2)

    }
    
    // Either  (a + b)
    object EitherType {

        object either_type {
            sealed trait Either[A, B]
            case class Left[A](value: A) extends Either[A, Nothing]
            case class Right[B](value: B) extends Either[Nothing, B]
        }

        def toInt(s: String): Either[String, Int] = try {
            Right(s.toInt)
        } catch {
            case _ : Exception => Left(s"$s is not an Int")
        }

        val v = toInt("1").map(_*2)
        v.foreach { value =>
            println(s"v = $value")
        }

        val notAnInt = toInt("not an Int").map(_*2)
        notAnInt.foreach { value =>
            println(s"v = $value")
        }

        def add(x: String, y: String) = for {
            a <- toInt(x)
            b <- toInt(y)
        } yield a + b

        def add(x: String, y: String) = for {
            a <- toInt(x)
            b <- toInt(y)
        } yield 0.0 + a + b
    }

}

// import scala.util.{Try, Success, Failure}


object try_type {
    sealed trait Try[A]
    case class Success[A](value: A) extends Try[A]
    case class Failure(ex: Throwable) extends Try[A]
}

// Try[A] ~ Either[Throwable, A]
// Success(a) <=> Right(a)
// Failure(ex) <=> Left(ex)


object course1_7_transformations {
 
    val amounts = List(4.99, 5.99, 10.00)

    // just combine values
    val sum1 = amounts.reduce(_ + _)

    // zero have the same type
    val sum = amounts.foldLeft(0.0)(_ + _)

    // zero have a specific type, use left
    def incLeft(acc: Int, d: Double) = acc + 1
    val count = amounts.foldLeft[Int](0)(incLeft)    

    // zero have a specific type, use right
    def incRight(d: Double, acc: Int) = acc + 1
    val count = amounts.foldRight[Int](0)(incRight)    

    // fold
    // for option
    val notAValue: Option[Boolean] = None
    val aTrueValue: Option[Boolean] = Some(true)
    val aFalseValue: Option[Boolean] = Some(false)
    def ternaryToInt(v: Option[Boolean]) = v.fold(0)(b => if (b) 1 else 2)
    Seq(notAValue, aTrueValue, aFalseValue).map(ternaryToInt)

    def ternaryToInt(v: Option[Boolean]) = v match {
        case None => 0
        case Some(true) => 1
        case Some(false) => 2
    }
    
    // for either
    val either: Either[Exception, String] = Right("a value")
    val eitherType = either.fold(_ => "an error", _ => "a value")
}

object course1_8_regular_expression {

    val C = "[A-Z]*".r
    val v = "AEIOU"
    // Char.matches(v)
    C.findFirstMatchIn("AAAA2AAAA")
    C.findAllMatchIn("AAAA2AAAA")

    // see documentation https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
    // and then capture group
    // and then
}

object course1_9_pattern_matching {    
    val array = Array(1, 2)
    val Array(a, b) = array

    case class Person(firstName: String, lastName: String, age: Int)
    val johnDoe = Person("john", "doe", 33)
    val Person(firstName, lastName, age) = johnDoe
    
    // https://docs.scala-lang.org/tour/extractor-objects.html
    // Example of CustomerId

    // Example of regex
    val LineRegex = "([^,]+)[,]([^,]+)[,]([0-9]+)".r
    val line = "jane,doe,33"
    val LineRegex(firstName, lastName, age) = line 

    // within for comprehension
    def isJohnDoe(firstName: String, lastName: String) = firstName == "John" && lastName == "Doe" 
    val persons = for {
        firstNames <- Array("John", "Jane")
        lastNames <- Array("Doe", "Smith")
        ages <- Array(10, 20, 33)
        line = s"$firstNames,$lastNames,$ages" if ages >= 18 // only adults 
        LineRegex(firstName, lastName, age) = line if !isJohnDoe(firstName, lastName) // no John Doe
    } yield Person(firstName, lastName, age.toInt)

}

/// let’s introduce flatMap


object course1_9_date_api {

}

object xxx_char_encoding {

}

object course1_10_csv_file_parsing_example { 
}

object course1_11_json_api { 
    // TODO: select 1 API (spark)
}
