package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class DuplicateEncoderSpec extends AnyFlatSpec {

  val testData: Seq[(String, String)] = List(
    ("", ""),
    ("din", "((("),
    ("recede", "()()()"),
    ("Success", ")())())"),
    ("(( @", "))((")
  )

  it should "count vowel on all inputs correctly" in {
    testData.map { case (input, expected) =>
      DuplicateEncoder.duplicateEncode(input) shouldEqual expected
    }
  }
}
