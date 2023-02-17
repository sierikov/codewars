package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class ProductOfConsecutiveFibNumbersTest extends AnyFlatSpec {

  val testData: Seq[(Long, Array[Int])] = List(
    (4895L, Array(55, 89, 1)),
    (5895L, Array(89, 144, 0)),
    (74049690L, Array(6765, 10946, 1))
  )

  it should "calculate correctly using immutable" in {
    testData.map { case (input, expected) =>
      ProductOfConsecutiveFibNumbers.find(input) shouldEqual expected
    }
  }

  it should "calculate correctly using mutable" in {
    testData.map { case (input, expected) =>
      ProductOfConsecutiveFibNumbers.findMutable(input) shouldEqual expected
    }
  }
}
