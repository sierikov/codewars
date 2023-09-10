package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec

class AreTheyTheSameSpec extends AnyFlatSpec {
  private val seq1 = Seq(121, 144, 19, 161, 19, 144, 19, 11)
  private val seq2 = Seq(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)
  
  it should "return true" in {
    assert(AreTheyTheSame.comp(seq1, seq2))
  }
}
