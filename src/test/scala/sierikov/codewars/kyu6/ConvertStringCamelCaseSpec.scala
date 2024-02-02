package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class ConvertStringCamelCaseSpec extends AnyFlatSpec {
  private val testCases = Map(
    "the-stealth-warrior" -> "theStealthWarrior",
    "The_Stealth_Warrior" -> "TheStealthWarrior",
    "the_stealth_warrior" -> "theStealthWarrior",
    "the-stealth-warrior" -> "theStealthWarrior",
    "theStealthWarrior" -> "theStealthWarrior"
  )

  testCases.foreach { case (input, expected) =>
    it should s"convert $input to $expected" in {
      ConvertStringCamelCase.toCamelCase(input) shouldBe expected
    }
  }

}
