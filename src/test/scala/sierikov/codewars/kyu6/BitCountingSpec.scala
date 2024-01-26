package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class BitCountingSpec extends AnyFlatSpec {
  private val data = Seq(
    (0, 0),
    (4, 1),
    (7, 3),
    (9, 2),
    (10, 2),
    (1234, 5)
  )
  
  data.foreach {
    case (input, expected) =>
      it should s"return $expected for $input" in {
        BitCounting.countBits(input) shouldBe expected
      }
  }
}
