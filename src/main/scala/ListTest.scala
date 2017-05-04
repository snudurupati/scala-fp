/**
  * Created by snudurupati on 4/24/17.
  */

import scalafp.datastructures.LinkedList

object ListTest {

  def main(args: Array[String]): Unit = {
    println(LinkedList.sum(LinkedList(1, 2, 3, 4, 5, 6)))

    //return tail
    val n = 7
    val ll = LinkedList(1, 2, 3, 4)
    //println(s"tail of $ll is ${LinkedList.tail(ll)}")
    println(s"removed first $n elements from $ll we get ${LinkedList.drop(ll, n)}")
  }

}
