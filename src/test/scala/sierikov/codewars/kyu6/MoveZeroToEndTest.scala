package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class MoveZeroToEndTest extends AnyFlatSpec {
  val testData: Seq[(Array[String], Array[String], Array[String])] = List(
    (Array("live", "arp", "strong"),
     Array("lively", "alive", "harp", "sharp", "armstrong"),
     Array("arp", "live", "strong")
    )
  )

  it should "calculate correctly using immutable" in {
    testData.map { case (input1, input2, expected) =>
      WhichAreIn.inArray(input1, input2) shouldEqual expected
    }
  }
}
