package pack

object Hello extends App {
  val p = Person("Alvin Alexander")
  println("Hello from " + p.name)
  
  if(true) {
    println("true")
  } else {
	println("false")
  }
}

case class Person(var name: String)