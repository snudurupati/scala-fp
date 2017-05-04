/**
  * Created by snudurupati on 4/21/17.
  * parametric polymorphism
  */

object Polymorphic {
  //partial function: takes a value and function of two arguments and returns a function of one argument
  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)


  //currying converts a function of N arguments into a function of one argument that returns another function
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => ((b: B) => f(a, b))


  //uncurry
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)

  //functional composition, feeds the output of one function to another function as input
  def compose[A, B, C](f: A => B, g: B => C): A => C =
    a => g(f(a))

}






