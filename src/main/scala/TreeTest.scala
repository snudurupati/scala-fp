/**
  * Created by snudurupati on 5/9/2017.
  */
import scalafp.datastructures.{Tree, Branch, Leaf}

object TreeTest {

  def main(args: Array[String]): Unit = {

    val t = Branch(Branch(Leaf(3), Leaf(2)), Branch(Leaf(1), Leaf(10)))
    println(s"tree size is ${Tree.size(t)}")
    println(s"maximum element is ${Tree.maximum(t)}")
    println(s"maximum depth is ${Tree.depth(t)}")
    println(s"adding 1 to each node ${Tree.map(t)(a => a + 1)}")
  }

}
