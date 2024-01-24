package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class SumOfPositiveSpec extends AnyFlatSpec {

  import SumOfPositive._

  val testCases = List(
    (Array(2, 2), 4),
    (Array(1, -2, 3, 4, 5), 13),
    (Array(-1, -2, -3, -4, -5), 0)
  )

  it should "return negative numbers" in {
    testCases.map { case (arr, expected) =>
      positiveSum(arr) shouldEqual expected
    }
  }

}
