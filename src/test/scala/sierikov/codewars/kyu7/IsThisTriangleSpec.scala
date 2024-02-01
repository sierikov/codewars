package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class IsThisTriangleSpec extends AnyFlatSpec {
  private val tests = Seq(
    (1, 2, 2, true),
    (7, 2, 2, false),
    (1, 2, 3, false),
    (1, 3, 2, false),
    (3, 1, 2, false),
    (5, 1, 2, false),
    (1, 2, 5, false),
    (2, 5, 1, false),
    (4, 2, 3, true),
    (5, 1, 5, true),
    (2, 2, 2, true),
    (-1, 2, 3, false),
    (1, -2, 3, false),
    (1, 2, -3, false),
    (0, 2, 3, false)
  )

  tests.foreach { case (a, b, c, expected) =>
    it should s"return $expected when sides are ($a, $b, $c)" in {
      IsThisTriangle.isTriangle(a, b, c) shouldBe expected
    }
  }
}
