import scalafp.datastructures._

object ListTest {

  def main(args: Array[String]) {
    println(LinkedList.sum(LinkedList(1, 2, 3, 4, 5, 6)))

    //return tail
    val n = 4
    val ll = LinkedList(1, 2, 3, 4, 5)
    //println(s"tail of $ll is ${LinkedList.tail(ll)}")
    /*
    println(s"removed first $n elements from $ll we get ${LinkedList.drop(ll, n)}")

    val lm = LinkedList.dropWhile(ll)(x => x%2 == 0)
    println(s"removed even numbered elements from $ll we get $lm")

    println(s"replace head from $ll and replace with $n and we get ${LinkedList.setHead(ll, n)}")

    println(s"appending $ll and $lm and we get ${LinkedList.append(ll, lm)}")

    println(s"removed last element from $ll we get ${LinkedList.init(ll)}")
    */

    println(s"sum of $ll is ${LinkedList.foldRight(ll, 0)(_ + _)}")

    println(s"sum of $ll is ${LinkedList.foldLeft(ll, 0)(_ + _)}")
  }

}
