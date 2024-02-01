package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class YourOrderPleaseSpec extends AnyFlatSpec {

  private val tests = List(
    ("is2 Thi1s T4est 3a", "Thi1s is2 3a T4est"),
    ("4of Fo1r pe6ople g3ood th5e the2", "Fo1r the2 g3ood 4of th5e pe6ople"),
    ("", "")
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected given $input" in {
      YourOrderPlease.order(input) shouldBe expected
    }
  }

}
