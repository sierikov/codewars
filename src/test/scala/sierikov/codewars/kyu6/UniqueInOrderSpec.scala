package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class UniqueInOrderSpec extends AnyFlatSpec {

  private val tests = List(
    ("AAAABBBCCDAABBB", Seq('A', 'B', 'C', 'D', 'A', 'B')),
    ("ABBCcAD", Seq('A', 'B', 'C', 'c', 'A', 'D'))
  )

  private val digits = List(
    (Seq(1, 2, 3, 3, 5), Seq(1, 2, 3, 5)),
    (Seq(1, 2, 2, 3), Seq(1, 2, 3))
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for input $input" in {
      UniqueInOrder.uniqueInOrder(input) shouldBe expected
    }
  }

  digits.foreach { case (input, expected) =>
    it should s"return $expected for input $input" in {
      UniqueInOrder.uniqueInOrder(input) shouldBe expected
    }
  }

}
