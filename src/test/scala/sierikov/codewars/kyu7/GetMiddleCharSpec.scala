package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class GetMiddleCharSpec extends AnyFlatSpec {

  private val tests = List(
    ("test",    "es"),
    ("testing", "t"),
    ("middle",  "dd"),
    ("A",       "A"),
    ("of",      "of")
  )

  tests.foreach {
    case (input, expected) =>
      it should s"return $expected for $input" in {
        GetMiddleChar.middle(input) shouldBe expected
      }
  }
}
