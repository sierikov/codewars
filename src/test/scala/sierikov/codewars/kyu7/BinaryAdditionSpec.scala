package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class BinaryAdditionSpec extends AnyFlatSpec {

  private val tests = List(
    (1, 1, "10"),
    (0, 1, "1"),
    (1, 0, "1"),
    (2, 2, "100"),
    (51, 12, "111111"),
    (0, 0, "0"),
    (100, 100, "11001000")
  )

  tests.foreach { case (a, b, expected) =>
    it should s"return $expected for $a + $b" in {
      BinaryAddition.addBinary(a, b) shouldBe expected
    }
  }
}
