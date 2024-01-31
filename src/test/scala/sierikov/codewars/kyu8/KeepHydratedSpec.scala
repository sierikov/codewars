package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class KeepHydratedSpec extends AnyFlatSpec {
  private val tests = List(
    (3.0, 1),
    (6.7, 3),
    (11.8, 5)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for $input" in {
      KeepHydrated.litres(input) shouldBe expected
    }
  }
}
