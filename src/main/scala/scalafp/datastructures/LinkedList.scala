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

  def dropn[A](l: LinkedList[A], n: Int): LinkedList[A] = l match {
    case Nil => Nil
    case Cons(_, xs) =>
      @annotation.tailrec
      def go(as: LinkedList[A], acc: Int): LinkedList[A]  =
        if (acc > n) as
        else go(tail(as), acc+1)
      go(l, 1)

  }

  //a simpler drop
  def drop[A](l: LinkedList[A], n: Int): LinkedList[A] =
    if (n <= 0) l
    else l match {
      case Nil => Nil
      case Cons(_, t) => drop(t, n-1)
    }

  def dropWhile[A](l: LinkedList[A])(f: A => Boolean): LinkedList[A] =
    l match {
      case Cons(h, t) if f(h) => dropWhile(t)(f)
      case _ => l
  }

  def setHead[A](l: LinkedList[A], a:A): LinkedList[A] =
    l match {
      case Cons(h, t) => Cons(a, t)
    }

  def append[A](a1: LinkedList[A], a2: LinkedList[A]): LinkedList[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  //deletes the tail of the list
  def init[A](l: LinkedList[A]): LinkedList[A] =
    l match {
      case Cons(_, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
    }

  def foldRight[A,B](l: LinkedList[A], z: B)(f: (A, B) => B): B =
    l match {
      case Nil => z
      case Cons(h, t) => f(h, foldRight(t, z)(f))
    }

  def length[A](l: LinkedList[A]): Int =
    foldRight(l, 0)((_, y) => 1 + y)

  @annotation.tailrec
  def foldLeft[A,B](l: LinkedList[A], z: B)(f: (B, A) => B): B =
    l match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }

  def reverse[A](l: LinkedList[A]): LinkedList[A] = {
    @annotation.tailrec
    def go(as: LinkedList[A], acc: LinkedList[A]): LinkedList[A] =
      as match {
        case Nil => acc
        case Cons(h, t) => go(t, Cons(h, acc))
      }
    go(l, Nil)
  }

  def reverse2[A](l: LinkedList[A]): LinkedList[A] =
    foldLeft(l, LinkedList[A]())((t, h) => Cons(h, t))

  def length2[A](l: LinkedList[A]): Int =
    foldLeft(l: LinkedList[A], 0)((t, _) => 1 + t)

  def append2[A](as: LinkedList[A], bs: LinkedList[A]): LinkedList[A] =
    foldLeft(as, bs)((b, a) => Cons(a, b))

  def add1(as: LinkedList[Int]): LinkedList[Int] =
    foldRight(as, LinkedList[Int]())((h, acc) => Cons(h + 1, acc))

  def dString(dl: LinkedList[Double]): LinkedList[String] =
    foldRight(dl, LinkedList[String]())((a, b) => Cons(a.toString, b))

  //exclusively recursive map - not stack-safe
  def map1[A,B](l: LinkedList[A])(f: A => B): LinkedList[B] =
    l match {
      case Nil => Nil
      case Cons(h, t) => Cons(f(h), map1(t)(f))
    }
  //map using foldRight - not stack-safe
  def map[A,B](l: LinkedList[A])(f: A => B): LinkedList[B] =
    foldRight(l, Nil: LinkedList[B])((a, b) => Cons(f(a), b))

  def filter1[A](l: LinkedList[A])(f: A => Boolean): LinkedList[A] =
    l match {
      case Cons(h, t) if f(h) => filter1(t)(f)
      case _ => l
    }

  def filter[A](l: LinkedList[A])(f: A => Boolean): LinkedList[A] =
    foldRight(l, Nil: LinkedList[A])((a, b) => if (f(a)) Cons(a, b) else b)

  val example = Cons(1, Cons(2, Cons(3, Nil)))
  val example2 = List(1,2,3)
  val total = sum(example)

}
