package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class BasicMathematicalOperationsSpec extends AnyFlatSpec {
  private val tests = List(
    ("+", 4, 7, 11),
    ("-", 15, 18, -3),
    ("*", 5, 5, 25),
    ("/", 49, 7, 7)
  )

  tests.foreach { case (op, value1, value2, expected) =>
    it should s"return $expected for $value1 $op $value2" in {
      BasicMathematicalOperations.basicOp(op.head, value1, value2) shouldBe expected
    }
  }
}
