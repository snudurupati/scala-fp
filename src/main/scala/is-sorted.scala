/**
  * Created by snudurupati on 4/19/2017.
  * Checks if an array is sorted
  * takes a comparison function and checks if an array is sorted
  * works for any sort order (ascending or descending) depending on the comparison function (greater or lesser)
  * uses parametric polymorphism
  */
//

def isSorted[@specialized A] (as: Array[A], gt: (A, A) => Boolean): Boolean = {
  @annotation.tailrec
  def go(prev: Int, curr: Int): Boolean = {
    if (curr < as.length) {
      if (!gt(as(prev), as(curr))) false
      else go(curr, curr + 1)
    }
    else true
  }
  go(0, 1)
}

//test cases fo int, double and char arrays
val l = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val res1 = isSorted(l, (x: Int, y: Int) => x < y)
println(if(res1) "array is sorted" else "array is not sorted")

//by changing the comparison function we can also account for duplicated values
val ar = Array('a', 'b', 'c', 'd', 'e', 'e', 'e','i', 'j', 'k')
val res2 = isSorted(ar, (x: Char, y: Char) => x <= y)
println(if(res2) "array is sorted" else "array is not sorted")

val f = Array(2.4, 4.1, 5.3, 1.2)
val res3 =  isSorted(f, (x: Double, y: Double) => x < y)
println(if(res3) "array is sorted" else "array is not sorted")

