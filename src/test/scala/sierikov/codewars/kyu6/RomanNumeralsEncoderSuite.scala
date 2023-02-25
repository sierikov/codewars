package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec

class RomanNumeralsEncoderSuite extends AnyFlatSpec {
  it should "pass basic tests" in {
    val testCases = List( // arabic, expected
      (1, "I"),
      (3, "III"),
      (4, "IV"),
      (6, "VI"),
      (14, "XIV"),
      (21, "XXI"),
      (89, "LXXXIX"),
      (91, "XCI"),
      (984, "CMLXXXIV"),
      (1000, "M"),
      (1666, "MDCLXVI"),
      (1889, "MDCCCLXXXIX"),
      (1989, "MCMLXXXIX"),
      (2008, "MMVIII")
    )

    testCases.foreach { case (arabic, expected) =>
      assertResult(expected, s"\nInput:\n  arabic = $arabic") { RomanNumeralsEncoder.encode(arabic) }
    }
  }
}
