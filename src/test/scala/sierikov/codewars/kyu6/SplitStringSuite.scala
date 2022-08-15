package sierikov.codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SplitStringSuite extends AnyFunSuite with Matchers {

  test("example") {
    SplitStrings.solution("asdfadsf") shouldEqual List("as", "df", "ad", "sf")
    SplitStrings.solution("asdfads") shouldEqual List("as", "df", "ad", "s_")
  }

  test("empty") {
    SplitStrings.solution("") shouldEqual List()
    SplitStrings.solution("a") shouldEqual List("a_")
  }
}
