package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec

class RegexValidatePinCodeSpec extends AnyFlatSpec {
  import RegexValidatePinCode._

  "validatePin" should "return false for pins with length other than 4 or 6" in {
    val testCases = List(
      "1",
      "12",
      "123",
      "12345",
      "1234567",
      "00000000"
    )

    testCases.foreach { case pin =>
      assertResult(false, s"\nInput\n pin = \"$pin\"")(validatePin(pin))
    }
  }

  it should "return false for pins characters other than digits" in {
    val testCases = List(
      "a234",
      ".234",
      "-123",
      "-1234",
      "1.23"
    )

    testCases.foreach { case pin =>
      assertResult(false, s"\nInput\n pin = \"$pin\"")(validatePin(pin))
    }
  }

  it should "return true for valid pins" in {
    val testCases = List(
      "1234",
      "0000",
      "1111",
      "123456",
      "098765",
      "000000",
      "123456",
      "090909"
    )

    testCases.foreach { case pin =>
      assertResult(true, s"\nInput\n pin = \"$pin\"")(validatePin(pin))
    }
  }
}
