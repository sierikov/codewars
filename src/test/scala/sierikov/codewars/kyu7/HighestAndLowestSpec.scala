package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class HighestAndLowestSpec extends AnyFlatSpec {
  import HighestAndLowest._

  val testCases = List(
    ("1 2 3 4 5", "5 1"),
    ("1 2 -3 4 5", "5 -3"),
    ("1 9 3 4 -5", "9 -5")
  )

  it should "return highest and lowest numbers" in {
    testCases.map { case (numbers, expected) =>
      highAndLow(numbers) shouldEqual expected
    }
  }

}
