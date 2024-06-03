package sierikov.codewars.kyu4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldBe

class MaximumSubarraySumSuite extends AnyFlatSpec {

  import MaximumSubarraySum._

  private val testCases = Map(
    Array[Int]() -> 0,
    Array(-2, 1, -3, 4, -1, 2, 1, -5, 4) -> 6,
    Array(1, -2, 3, 5, -1, 2) -> 9
  )

  testCases.foreach { case (input, expected) =>
    it should s"Maximum ${input.mkString("(", ", ", ")")} is $expected" in {
      sequence(input) shouldBe expected
    }
  }

}
