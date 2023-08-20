package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class CenturyFromYearSpec extends AnyFlatSpec {

  val testData: Seq[(Int, Int)] = List(
    (1705, 18),
    (1900, 19),
    (1601, 17),
    (2000, 20),
    (89, 1),
    (1, 1)
  )

  it should "correctly encode given strings" in {
    testData.map { case (input, expected) =>
      CenturyFromYear.centuryFromYear(input) shouldEqual expected
    }
  }
}
