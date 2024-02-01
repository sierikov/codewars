package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class ConvertNumberToReversedArrayDigitsSpec extends AnyFlatSpec {
  private val tests = List(
    (35231L, Seq(1, 3, 2, 5, 3)),
    (348597L, Seq(7, 9, 5, 8, 4, 3)),
    (0L, Seq(0)),
    (23582357L, Seq(7, 5, 3, 2, 8, 5, 3, 2)),
    (984764738L, Seq(8, 3, 7, 4, 6, 7, 4, 8, 9)),
    (45762893920L, Seq(0, 2, 9, 3, 9, 8, 2, 6, 7, 5, 4)),
    (548702838394L, Seq(4, 9, 3, 8, 3, 8, 2, 0, 7, 8, 4, 5))
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for $input" in {
      ConvertNumberToReversedArrayDigits.digitize(input) shouldBe expected
    }
  }
}
