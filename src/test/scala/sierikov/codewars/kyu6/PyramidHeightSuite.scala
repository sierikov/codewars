package sierikov.codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PyramidHeightSuite extends AnyFunSuite with Matchers {

  val testCases = List( // (input, expected)
    (1, 1),
    (4, 1),
    (5, 2),
    (29, 3),
    (30, 4),
    (31, 4),
    (1240, 15),
    (1241, 15),
    (1239, 14),
    (1496, 16),
    (1495, 15),
    (4324, 23),
    (4323, 22),
    (4899, 23),
    (4900, 24),
    (5524, 24),
    (5525, 25),
    (6200, 25),
    (6201, 26),
    (6254, 26)
  )
  test(s"pyramidHeight should calculate correctly the height") {
    testCases.foreach { case (input, expected) =>
      PyramidHeight.pyramidHeight(input) shouldEqual expected
    }
  }
}
