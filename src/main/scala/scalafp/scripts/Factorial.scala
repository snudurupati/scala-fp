/**
  * Created by snudurupati on 4/15/17.
  * Factorial of a number
  * By convention recursive functions are referred to by go or loop
  * A recursive function is tail-recursive if the recursive call is in tail position i.e.
  * recursive call is the last action performed in the function
  */

object Factorial {

  //non-functional way

  def factorial1(n: Int): Int = {
    var j = 1
    for (i <- 1 to n)
      j = j * i
    j
  }

  println(s"The factorial of 7 is ${factorial1(7)}")

  //using recursion
  def rfactorial(n: Int): Int = {
    if (n == 1) 1
    n * rfactorial(n - 1)
  }

  println(s"The factorial of 7 is ${rfactorial(7)}")

  //using tail-recursion
  def factorial(n: Int): Int = {
    @annotation.tailrec //annotation to tell the compiler we are assumimg a tail recursion
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n, 1)
  }

  println(s"The factorial of 7 is ${factorial(7)}")

  //functional style - using higher oder function
  def ffactorial(n: Int): Int = 1 to n reduce (_ * _)

  println(s"The factorial of 7 is ${ffactorial(7)}")

}
