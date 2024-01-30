package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class ShortestWordSpec extends AnyFlatSpec {

  private val tests = List(
    ("bitcoin take over the world maybe who knows perhaps", 3),
    ("turns out random test cases are easier than writing out basic ones", 3),
    ("lets talk about javascript the best language", 3),
    ("i want to travel the world writing code one day", 1),
    ("lets all go on holiday somewhere very cold", 2)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for ${input.take(8)}.." in {
      ShortestWord.findShort(input) shouldBe expected
    }
  }
}
