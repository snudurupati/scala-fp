/**
  * Created by snudurupati on 4/18/2017.
  *
  * Functions are ordinary objects, so referred to as first-class functions
  */
object FirstClassFunction {
  val minus = new Function2[Int, Int, Int] { //Function2 is a Scala trait representing a function with 2 arguments
    def apply(a: Int, b: Int): Int = a - b
  }

  println(minus.apply(3, 5)) //same as below
  println(minus(3, 5))


}

