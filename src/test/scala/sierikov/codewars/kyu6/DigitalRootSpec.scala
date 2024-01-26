package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class DigitalRootSpec extends AnyFlatSpec {
  private val twoDigitsData = Seq(
    (132189, 6),
    (493193, 2)
  )

  it should "sum digits" in {
    DigitalRoot.digitalRoot(16) shouldBe 7
  }

  it should "sum digits again if result is 2-digits long" in {
    twoDigitsData.foreach {
      case (input, expected) =>
        DigitalRoot.digitalRoot(input) shouldBe expected
    }
  }
}
