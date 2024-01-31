package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class StringEndsWithSpec extends AnyFlatSpec {

  private val tests = List(
    ("samurai", "ai", true),
    ("ninja", "ja", true),
    ("sensei", "i", true),
    ("abc", "abc", true),
    ("abcabc", "bc", true),
    ("fails", "ails", true),
    ("test", "", true),
    ("sumo", "omo", false),
    ("samurai", "ra", false),
    ("abc", "abcd", false),
    ("ails", "fails", false),
    ("this", "fails", false),
    ("spam", "eggs", false)
  )

  tests.foreach { case (input, suffix, result) =>
    it should s"return $result for $input with '$suffix''" in {
      StringEndsWith.solution(input, suffix) shouldBe result
    }
  }
}
