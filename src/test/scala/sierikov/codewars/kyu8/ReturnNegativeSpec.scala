package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class ReturnNegativeSpec extends AnyFlatSpec {

  import ReturnNegative._

  val testCases = List(
    (42, -42),
    (0, 0),
    (1, -1),
    (-1, -1)
  )

  it should "return negative numbers" in {
    testCases.map { case (number, expected) =>
      makeNegative(number) shouldEqual expected
    }
  }

}
