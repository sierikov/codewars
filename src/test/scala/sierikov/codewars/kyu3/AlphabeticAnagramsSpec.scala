package sierikov.codewars.kyu3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import sierikov.codewars.kyu7.Isogram

class AlphabeticAnagramsSpec extends AnyFlatSpec {
  import AlphabeticAnagrams._

  val testCases: List[(String, BigInt)] = List(
    ("A", BigInt(1)),
    ("AAAA", BigInt(1)),
    ("KOOB", BigInt(6)),
    ("ABAB", BigInt(2)),
    ("AAAB", BigInt(1)),
    ("BAAA", BigInt(4)),
    ("QUESTION", BigInt(24572)),
    ("BOOKKEEPER", BigInt(10743)),
    ("STRESSTESTSTRINMANYLETTERS", BigInt("1864701479591384275"))
  )

  testCases.foreach { case (xs, expected) =>
    it should s"return $expected for $xs" in {
      listPosition(xs) shouldBe expected
    }
  }
}
