package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

// kata: Eliminate the intruders! Bit manipulation
// link: https://www.codewars.com/kata/5a0d38c9697598b67a000041
class EliminateIntrudersSpec extends AnyFlatSpec {
  "eliminateUnsetBits" should "pass basic tests" in {
    val testCases = Seq(
      ("11010101010101", 255),
      ("111", 7),
      ("1000000", 1),
      ("000", 0)
    )

    testCases.foreach { case (number, expected) =>
      EliminateIntruders.eliminateUnsetBits(number) shouldBe expected
    }
  }
}
