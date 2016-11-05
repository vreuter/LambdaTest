package demo

import com.fortysevendeg.lambdatest._

// format: OFF

class Immutable extends LambdaTest {

  val act = test("empty") {
    val s = Set.empty[Int]
    assertEq(s.size, 0, "empty") +
    nest {
      val s1 = s + 3
      assertEq(s1.size, 1, "insert") +
      nest {
        val s2 = s1 - 3
        assertEq(s2.size, 0, "delete")
      }
    }
  }
}

object Immutable {
  def main(args: Array[String]): Unit = {
    run("immutable", new Immutable)
  }
}