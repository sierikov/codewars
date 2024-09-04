package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import sierikov.codewars.kyu5.GreedIsGood.*

class GreedIsGoodTest extends AnyFlatSpec {
  it should "pass basic tests" in {
    val testCases = List(
      (List(2, 3, 4, 6, 2), 0),
      (List(1, 1, 1, 3, 3), 1000),
      (List(2, 2, 2, 3, 3), 200),
      (List(3, 3, 3, 3, 3), 300),
      (List(4, 4, 4, 3, 3), 400),
      (List(5, 5, 5, 3, 3), 500),
      (List(6, 6, 6, 3, 3), 600),
      (List(1, 1, 1, 1, 3), 1100),
      (List(1, 1, 1, 1, 5), 1150),
      (List(2, 4, 4, 5, 4), 450),
      (List(3, 4, 5, 3, 3), 350),
      (List(1, 5, 1, 3, 4), 250)
    )

    testCases.foreach { case (dice, expected) =>
      assertResult(expected, s"\nInput\n  dice = $dice")(score(dice))
    }
  }
}
