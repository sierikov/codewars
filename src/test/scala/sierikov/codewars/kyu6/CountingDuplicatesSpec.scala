package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class CountingDuplicatesSpec extends AnyFlatSpec {
  private val tests = Seq(
    ("abcde", 0),
    ("abcdea", 1),
    ("indivisibility", 1),
    ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", 26)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for ${input.take(8)}" in {
      CountingDuplicates.duplicateCount(input) shouldBe expected
    }
  }
}
