package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.should

class LarioAndMuigiPipeProblemSpec extends AnyFlatSpec {
  import LarioAndMuigiPipeProblem._

  "pipeFix" should "pass basic tests" in {
    val testCases = Seq(
      (Seq(1, 2, 3, 5, 6, 8, 9), Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)),
      (Seq(1, 2, 3, 12), Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
      (Seq(6, 9), Seq(6, 7, 8, 9)),
      (Seq(-1, 4), Seq(-1, 0, 1, 2, 3, 4)),
      (Seq(1, 2, 3), Seq(1, 2, 3)),
      (Seq(2), Seq(2))
    )

    testCases.foreach { (nums, expected) =>
      assertResult(expected, s"\nInput:\n nums = $nums")(pipeFix(nums))
    }
  }

}
