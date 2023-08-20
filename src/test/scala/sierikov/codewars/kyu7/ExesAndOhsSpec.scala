package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class ExesAndOhsSpec extends AnyFlatSpec {

  private val tests = List(
    ("xo", true),
    ("xo0", true),
    ("xxxoo", false)
  )

  it should "count x and os on all inputs correctly" in {
    tests.map { case (input, expected) =>
      ExesAndOhs.xo(input) shouldEqual expected
    }
  }
}
