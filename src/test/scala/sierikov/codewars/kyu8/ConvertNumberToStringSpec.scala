package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class ConvertNumberToStringSpec extends AnyFlatSpec {

  import ConvertNumberToString._

  val testCases = List(
    (7, "7"),
    (42, "42"),
    (0, "0"),
    (-13, "-13"),
    (123, "123"),
    (999, "999")
  )

  it should "convert numbers to strings" in {
    testCases.map { case (number, expected) =>
      numberToString(number) shouldEqual expected
    }
  }

}
