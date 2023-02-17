package sierikov.codewars.kyu5

import org.scalatest.Assertion
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.{shouldBe, shouldEqual}

class JosephusSurvivorTest extends AnyFlatSpec with Matchers {

  val testData: Seq[(Int, Int, Int)] = List(
    (7, 3, 4),
    (11, 19, 10),
    (40, 3, 28),
    (14, 2, 13),
    (100, 1, 100),
    (1, 300, 1),
    (2, 300, 1),
    (5, 300, 1),
    (7, 300, 7),
    (300, 300, 265)
  )

  def checkOn(f: (Int, Int) => Int): Seq[Assertion] =
    testData.map { case (n, k, result) => f(n, k) shouldBe result }

  it must "calculate correctly using tailrec" in {
    checkOn(JosephusSurvivor.calc)
  }

  it must "calculate correctly using math" in {
    checkOn(JosephusSurvivor.calcMath)
  }

}
