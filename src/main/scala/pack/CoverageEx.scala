package pack

object CoverageEx {
    
  val o = 19  
  
  def main(args: Array[String]) = {
    val a = m()

    print("Done !")
  }
  def m() = {
    tryB()
    tryC()
    CoverageEx.if1()
    if2()
    optionM()
    listM(List(1,2), (true && false))
    patMat(1234)
    fun()
    dat()
    mapCase()
    mapEmpty()
    lazyVal()
    testThis()
    testPerson()
    simpleReturn()
    whileEx()
    liftEx()
  }
  
  def whileEx() = {
    var a = 1
    while(a < 3) {
        println(a)
        a = a + 1
    }
  }
  
  def simpleReturn() = {
    val a = 10
    a
  }
  
  class Person() {
    private var age_ = 0
    def age = age_
    def age_= (value:Int):Unit = age_ = value
  }
  
  def testPerson() = {
    val person = new Person()
    print(person.age)
    person.age = get4()
  }
  
  def testThis():Int = {
    val t = this
    this.o
  }
  
  def lazyVal() = {
    lazy val a = false && true
    val b = false && true
    
    lazy val c = true
    lazy val d = c && true
    
    lazy val e = false
    val f = true && e
  }
  
  def mapEmpty() = {
    val l = List(2,get4(),6,8)
    val l1 = l.filterNot(_%2 == 0).map(x =>               2*x)
  }
  
  def get4() = {4}
  
   def mapCase() = {
    val l = List(List(1,9),List(2,9),List(3,9),List(4,9))
    l.map{case x :: xs => x}
  }
  
  def dat() = {
    //val date = new Date()
    //print(date.getTime())
  }
  
  def fun() = {
    val k = 12 + 23
	/*
    val valFUnsed : Int => Boolean = x : Int => (x < 17 && (x +k) < k)
    val valF : Int => Boolean = x : Int => (x < 17 && (x +k) < k)
    def defFUnsed : Int => Boolean = x : Int => (x < 17 && (x +k) < k)
    def defF : Int => Boolean = x : Int => (x < 17 && (x +k) < k)
	
    valF(1) || defF(2) && defFUnsed(2) 
*/
  }
  def complexFunction() = {
        false
  }
  def if1():Int = {
    val k = 71
    val c = true || false && (true && false)
    

    
    
    val d = true || complexFunction()
    val e = true && false && (true && false)
    val f = true && (true && false)
    
    
    if(c){
        val d = 29 + k
        print(d)
    } else {
        print("Should not be called !")
    }
    return 1
  }
  def if2() = {
  	if(false) print("thenP") else print("elseP")
  }
  
  def patMat(asd : Int) = {
    val a = 12
    val k = asd

    a match {
        case 0 => if(false) print("thenP") else print("elseP")
        case 12 if (k == 1234) => print("12")
        case _ => print("Other")
    }
  }
  
  def optionM() = {
    val  op : Option[Int] = Some(2)
    
    op match {
        case Some(c) => print(c)
        case None => print("Should not be called !")
    }
  }
  
  def listM(l : List[Int], unUsed : Boolean):Unit = {
    l match {
        case x :: y :: z :: xs => print("Should not be called !")
        case x :: xs => print(x);listM(xs,true)
        case Nil => print("End of list !")
    }
  }
  def tryB() = {
    try {
       
       
       CoverageEx.throwEx(CoverageEx.throwEx(CoverageEx.throwEx(false)))
    } catch {
      case foo: IllegalArgumentException => print("Exception catched !")
      case _: Throwable => println("Got some other kind of exception")
    } finally {
            print("Finally block")
    }
    
    try {
       throwEx(throwEx(throwEx(false)))
    } catch {
      case foo: IllegalArgumentException => print("Exception catched !")
      case _: Throwable => println("Got some other kind of exception")
    } finally {
            print("Finally block")
    }
  }
  
 def tryC() = {
     try {
       
       val shoulBeCovered = true
       val shoulNOTBeCovered = true
       def3(shoulBeCovered, throwEx(true), shoulNOTBeCovered) // def3 should not be covered
    } catch {
      case foo: IllegalArgumentException => print("Exception catched !")
      case _: Throwable => println("Got some other kind of exception")
    }
  }
  def def3(a: Boolean, b: Boolean, c: Boolean):Boolean = {
    a && b && c
  }
  
  def throwEx(a : Boolean):Boolean = {
    if(a){
        throw new IllegalArgumentException("Argument is true !")
    } else {
        true
    }
  }
  
  def liftEx() = {
    try {
    
    A.f(3 ,B.g(10), complexFunction() )
    
    }catch{
          case _: Throwable => println("Got some other kind of exception")
    }
  }
  
  
  object A {
    def f(xx : Int, x : Int, y : Boolean) = {
        x
    }
  }
  
  object B {
    def g(x: Int) = {
        throw new IllegalArgumentException("Argument is true !")
    }
  }
}