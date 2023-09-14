package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SumOddNumbersSpec extends AnyFlatSpec with Matchers {
  "rowSumOddNumbers(1)" should "return 1" in {
    SumOddNumbers.rowSumOddNumbers(1) shouldBe 1
  }
  "rowSumOddNumbers(2)" should "return 8" in {
    SumOddNumbers.rowSumOddNumbers(2) shouldBe 8
  }
  "rowSumOddNumbers(13)" should "return 2197" in {
    SumOddNumbers.rowSumOddNumbers(13) shouldBe 2197
  }
  "rowSumOddNumbers(19)" should "return 6859" in {
    SumOddNumbers.rowSumOddNumbers(19) shouldBe 6859
  }
  "rowSumOddNumbers(41)" should "return 68921" in {
    SumOddNumbers.rowSumOddNumbers(41) shouldBe 68921
  }
}
