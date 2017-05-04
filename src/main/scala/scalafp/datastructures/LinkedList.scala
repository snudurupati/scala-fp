package scalafp.datastructures

/**
  * Created by snudurupati on 4/24/17.
  */


//List data type
sealed trait LinkedList[+A]

//data constructors
case object Nil extends LinkedList[Nothing]
case class Cons[+A](head: A, tail: LinkedList[A]) extends LinkedList[A]

//companion object with convenience functions
object LinkedList {

  def sum(ints: LinkedList[Int]): Int = ints match {
    case Nil => 0
    case Cons(x,xs) => x + sum(xs)
  }

  def product(ds: LinkedList[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): LinkedList[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](l: LinkedList[A]): LinkedList[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](l: LinkedList[A], n: Int): LinkedList[A] = l match {
    case Nil => Nil
    case Cons(_, xs) =>
      @annotation.tailrec
      def go(as: LinkedList[A], acc: Int): LinkedList[A]  =
        if (acc > n) as
        else go(tail(as), acc+1)
      go(l, 1)

  }

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1,2,3)
  val total = sum(example)

}
