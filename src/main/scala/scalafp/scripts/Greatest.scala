/*
Find the greatest from a list of integers.
 */

object Greatest {
  //generate a list of 25 random integers
  val r = new scala.util.Random
  val l = 1 to 25 map r.nextInt

  //greatest integer, the non-functional way

  var max = l(0) //mutable variable
  for (i <- l.indices)
    if (max < l(i)) max = l(i)

  println(f"The greatest integer is $max")


  //the functional-way

  def greatest(a: Int, b: Int): Int =
    if (a > b) a else b

  val fpmax = l.reduce(greatest) //passing functions as parameters to other functions

  println("The greatest integer is %d".format(fpmax))

}
