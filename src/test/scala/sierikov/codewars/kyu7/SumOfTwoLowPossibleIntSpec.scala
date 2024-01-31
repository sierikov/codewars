package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class SumOfTwoLowPossibleIntSpec extends AnyFlatSpec {

  private val tests = List(
    (List(5, 8, 12, 18, 22), 13),
    (List(7, 15, 12, 18, 22), 19),
    (List(25, 42, 12, 18, 22), 30),
    (List(1, 8, 12, 18, 5), 6),
    (List(13, 12, 5, 61, 22), 17)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for $input" in {
      SumOfTwoLowPossibleInt.sumTwoSmallest(input) shouldBe expected
    }
  }
}
