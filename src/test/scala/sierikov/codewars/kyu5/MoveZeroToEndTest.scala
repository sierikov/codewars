package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class MoveZeroToEndTest extends AnyFlatSpec {
  val testData: Seq[(List[Int], List[Int])] = List(
    (List(1, 2, 0, 1, 0, 1, 0, 3, 0, 1), List(1, 2, 1, 1, 3, 1, 0, 0, 0, 0)),
    (List(9, 0, 0, 9, 1, 2, 0, 1, 0, 1, 0, 3, 0, 1, 9, 0, 0, 0, 0, 9),
     List(9, 9, 1, 2, 1, 1, 3, 1, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    ),
    (List(0, 0), List(0, 0)),
    (List(0), List(0)),
    (List[Int](), List[Int]())
  )

  it should "calculate correctly using immutable" in {
    testData.map { case (input, expected) =>
      MoveZeroToEnd.move(input) shouldEqual expected
    }
  }
}
