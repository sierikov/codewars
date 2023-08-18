package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class VowelCountSpec extends AnyFlatSpec {

  val testData: Seq[(String, Int)] = List(
    ("", 0),
    ("a", 1),
    ("aa", 2),
    ("aeiou", 5),
    ("bcdfghjklmnpqrstvwxy z", 0),
    ("abcdefghijklmnopqrstuvwxy z", 5),
    ("etohu ldlvqusz jxxiano scumooyh ouc suvvjlxab akiuuq eiuiml aqnfhwfqosu eijkx qak apriygie aplhe roodaqjyy", 37)
  )

  it should "count vowel on all inputs correctly" in {
    testData.map { case (input, expected) =>
      VowelCount.getCount(input) shouldEqual expected
    }
  }
}
