package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class EqualSidesOfAnArraySpec extends AnyFlatSpec {
  private val tests: Seq[(Array[Int], Int)] = List(
    (Array(1, 2, 3, 4, 3, 2, 1), 3),
    (Array(1, 100, 50, -51, 1, 1), 1),
    (Array(1, 2, 3, 4, 5, 6), -1),
    (Array(20, 10, 30, 10, 10, 15, 35), 3),
    (Array(20, 10, -80, 10, 10, 15, 35), 0),
    (Array(10, -80, 10, 10, 15, 35, 20), 6),
    ((1 until 100).toArray, -1),
    (Array(0, 0, 0, 0, 0), 0),
    (Array(-1, -2, -3, -4, -3, -2, -1), 3),
    ((-100 until -1).toArray, -1)
  )

  tests.foreach { case (input, expected) =>
    val inputString = if input.length >= 10 then input.takeRight(8).mkString(",") else input.mkString(",")
    it should s"return $expected for array: $inputString" in {
      EqualSidesOfAnArray.findEvenIndex(input) shouldBe expected
    }
  }
}
