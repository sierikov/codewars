package sierikov.codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

import java.math.BigInteger

class FabergeEasterEggSpec extends AnyFlatSpec {

  import FabergeEasterEgg._

  private val testCases = List(
    (0, 0, "0"),
    (1, 51, "51"),
    (2, 1, "1"),
    (4, 17, "3213"),
    (16, 19, "524096"),
    (6015, 5, "31"),
    (23, 19, "524287"),
    // stress test
    (13, 550, "60113767426276772744951355")
  ).map { case (n, m, expected) =>
    (BigInteger.valueOf(n), BigInteger.valueOf(m), BigInteger(expected))
  }

  testCases.foreach { case (n, m, expected) =>
    it should s"return $expected for n = $n, m = $m" in {
      height(n, m) shouldBe expected
    }
  }

}
