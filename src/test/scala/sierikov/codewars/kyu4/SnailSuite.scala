package sierikov.codewars.kyu4

import org.scalatest.funsuite.AnyFunSuite

class SnailSuite extends AnyFunSuite {

  import Snail.snail

  test("should pass basic tests") {
    val input1 = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9))
    val res1 = List(1, 2, 3, 6, 9, 8, 7, 4, 5)
    assert(snail(input1) == res1)

    val input2 = List(
      List(1, 2, 3),
      List(8, 9, 4),
      List(7, 6, 5))
    val res2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    assert(snail(input2) == res2)

  }
}
