package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class WhoLikesItSpec extends AnyFlatSpec {

  val testData: Seq[(Array[String], String)] = List(
    (Array.empty, "no one likes this"),
    (Array("Peter"), "Peter likes this"),
    (Array("Jacob", "Alex"), "Jacob and Alex like this"),
    (Array("Max", "John", "Mark"), "Max, John and Mark like this"),
    (Array("Alex", "Jacob", "Mark", "Max"), "Alex, Jacob and 2 others like this")
  )

  it should "count vowel on all inputs correctly" in {
    testData.map { case (input, expected) =>
      WhoLikesIt.likes(input) shouldEqual expected
    }
  }
}
