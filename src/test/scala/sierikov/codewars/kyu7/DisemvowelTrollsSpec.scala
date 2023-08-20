package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class DisemvowelTrollsSpec extends AnyFlatSpec {

  val testData: Seq[(String, String)] = List(
    ("This website is for losers LOL!", "Ths wbst s fr lsrs LL!"),
    ("No offense but, Your writing is among the worst I've ever read", "N ffns bt, Yr wrtng s mng th wrst 'v vr rd")
  )

  it should "count vowel on all inputs correctly" in {
    testData.map { case (input, expected) =>
      DisemvowelTrolls.disemvowel(input) shouldEqual expected
    }
  }
}
