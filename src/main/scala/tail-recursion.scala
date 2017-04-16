/**
  * Created by snudurupati on 4/15/17.
  * A function to get the nth Fibonacci number using local tail-recursive function.
  */

def fib(num: Int): Int = {

  @annotation.tailrec
  def go(num: Int, count: Int, prev: Int, curr: Int): Int = {
    if (num == count) curr
    else go(num, count+1, curr, prev+curr)
    }

  go(num, 0, 0, 1)

  }

println(s"The 7th number in the Fibonacci series is ${fib(7)}")
