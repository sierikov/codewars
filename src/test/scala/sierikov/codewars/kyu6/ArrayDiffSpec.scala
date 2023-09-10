package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class ArrayDiffSpec extends AnyFlatSpec {

  import ArrayDiff._

  private val tests = Seq(
    (Seq(1, 2), Seq(1), Seq(2)),
    (Seq(1, 2, 2), Seq(1), Seq(2, 2)),
    (Seq(1, 2, 2), Seq(2), Seq(1)),
    (Seq(1, 2, 2), Seq(), Seq(1, 2, 2)),
    (Seq(), Seq(1, 2), Seq())
  )

  it should "find the difference between two arrays" in {
    tests.foreach { case (a, b, expected) =>
      arrayDiff(a, b) shouldBe expected
    }
  }

}
