package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldBe

class LastDigitOfLargeNumberSuite extends AnyFlatSpec {

  import LastDigitOfLargeNumber.*

  private val testCases: Map[(BigInt, BigInt), BigInt] = Map(
    (BigInt(0), BigInt(0)) -> 1,
    (BigInt(4), BigInt(1)) -> 4,
    (BigInt(4), BigInt(2)) -> 6,
    (BigInt(9), BigInt(7)) -> 9,
    (BigInt(10), BigInt(10000)) -> 0,
    (BigInt(592), BigInt(123)) -> 8,
    (BigInt(2).pow(200), BigInt(2).pow(300)) -> 6
  )

  testCases.foreach { case (input, expected) =>
    it should s"Pow (${stripTo10(input._1)}, ${stripTo10(input._2)}) is $expected" in {
      lastDigit(input._1, input._2) shouldBe expected
    }
  }

  private def stripTo10(n: BigInt): BigInt = BigInt(n.toString.drop(n.toString.length - 10))

}
