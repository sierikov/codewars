package sierikov.codewars.kyu5

import org.scalatest.funsuite.AnyFunSuite

class PerimeterOfSquaresInARectangleSuite extends AnyFunSuite {
  val testCases: Array[(Int, BigInt)] = Array(
    (5, BigInt(80)),
    (7, BigInt(216)),
    (20, BigInt(114624)),
    (30, BigInt(14098308)),
    (100, BigInt("6002082144827584333104"))
  )

  for ((n, r) <- testCases) yield check(n, r)

  def check(n: BigInt, res: BigInt): Unit = {
    test(s"perimeter($n) should be equal to $res") {
      val z = PerimeterOfSquaresInARectangle.perimeter(n)
      assert(z === res)
    }
  }

}
