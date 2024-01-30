package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class FindParityOutlierSpec extends AnyFlatSpec {
  private val tests = Seq(
    (List(2, 4, 6, 8, 10, 3), 3),
    (List(2, 4, 0, 100, 4, 11, 2602, 36), 11),
    (List(160, 3, 1719, 19, 11, 13, -21), 160)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for ${input.take(8)}" in {
      FindParityOutlier.findOutlier(input) shouldBe expected
    }
  }
}
