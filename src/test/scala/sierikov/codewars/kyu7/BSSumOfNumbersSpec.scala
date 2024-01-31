package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class BSSumOfNumbersSpec extends AnyFlatSpec {

  private val tests = List(
    (1, 0, 1),
    (1, 2, 3),
    (1, 1, 1),
    (-1, 2, 2)
  )

  tests.foreach { case (a, b, result) =>
    it should s"return $result for ($a, $b)" in {
      BSSumOfNumbers.getSum(a, b) shouldBe result
    }
  }
}
