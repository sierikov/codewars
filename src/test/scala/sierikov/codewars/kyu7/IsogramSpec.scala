package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class IsogramSpec extends AnyFlatSpec {

  private val tests = List(
    ("Dermatoglyphics", true),
    ("isogram", true),
    ("aba", false),
    ("moOse", false),
    ("isIsogram", false),
    ("", true)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for $input" in {
      Isogram.isIsogram(input) shouldBe expected
    }
  }
}
