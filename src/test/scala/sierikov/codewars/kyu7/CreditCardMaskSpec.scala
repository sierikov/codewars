package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class CreditCardMaskSpec extends AnyFlatSpec {

  private val tests = List(
    ("123", "123"),
    ("SF$SDfgsd2eA", "########d2eA"),
    ("4556364607935616", "############5616"),
    ("76607935616", "#######5616"),
    ("1", "1"),
    ("Skippy", "##ippy"),
    ("Nananananananananananananananana Batman!", "####################################man!"),
    ("12345", "#2345")
  )

  tests.foreach { case (input, expected) =>
    it should s"return ...${expected.takeRight(6)} with input ${input.takeRight(10)}" in {
      CreditCardMask.maskify(input) shouldBe expected
    }
  }
}
