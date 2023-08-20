package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class FindTheOddIntSpec extends AnyFlatSpec {

  val testData: Seq[(List[Int], Int)] = List(
    (List(20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5), 5),
    (List(1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5), -1),
    (List(20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5), 5),
    (List(10), 10),
    (List(1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1), 10),
    (List(5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10), 1)
  )

  it should "find and count int on all inputs correctly" in {
    testData.map { case (input, expected) =>
      FindTheOddInt.findOdd(input) shouldEqual expected
    }
  }
}
