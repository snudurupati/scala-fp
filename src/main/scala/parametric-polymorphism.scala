/**
  * Created by snudurupati on 4/19/2017.
  * Binary Search
  */

val l = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val key = 9

//binary search the traditional way
def binSearch(l: Array[Int], key: Int): Int = {
  var left = 0
  var right = l.length-1
  while (left<=right) {
    val mid = left + (right-left)/2
    if (l(mid)==key)
      return mid
    else if (l(mid)>key)
      right = mid-1
    else
      left = mid+1
  }
  -1
}

//binary search using tail recursion
def binarySearch(l: Array[Int], key: Int): Int = {
  @annotation.tailrec
  def go(lo: Int, hi: Int): Int = {
    if(lo > hi) -1
    else {
      val mid = (lo + hi)/2
      val middle = l(mid)
      //println(s"lo = $lo, mid = $mid, hi = $hi")
      if(key == middle) mid
      else if (key < middle) go(lo, mid-1)  //search left half
      else go(mid+1, hi) //search right half
    }

  }
  go(0, l.length-1)
}

println(s"$key is located at the ${binarySearch(l, key)}th position in the array.")

/**
* extending binary search to be used with any type by accepting a comparison function as argument
* now this is a polymorphic function as we are abstracting over the type of input
*/
def binarySearch[A](l: Array[A], key: A, gt: (A, A) => Boolean): Int = {
  @annotation.tailrec
  def go(lo: Int, hi: Int): Int = {
    if(lo > hi) -1
    else {
      val mid = (lo + hi) / 2
      val middle = l(mid)
      val equal = !gt(key, middle) && !gt(middle, key)
      val lesser = gt(middle, key)
      //println(s"lo = $lo, mid = $mid, hi = $hi")
      if (equal) mid
      else if (lesser) go(lo, mid - 1) //search left half
      else go(mid + 1, hi) //search right half
    }
  }
  go(0, l.length-1)
}

val ar = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'i', 'j', 'k')
val d = 'g'
//here we use a lambda experssion for the comparison function argument.
println(s"$d is located at the ${binarySearch(ar, d, (x: Char, y: Char) => x > y)}th position in the array.")