package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class RgbToHexConversionTest extends AnyFlatSpec {

  val testData: Seq[(Int, Int, Int, String)] = List(
    (0, 0, 0, "000000"),
    (1, 2, 3, "010203"),
    (255, 255, 255, "FFFFFF"),
    // edge cases
    (-20, 275, 125, "00FF7D"),
    (134, -32, 91, "86005B"),
    (33, -39, 21, "210015"),
    (279, 23, 156, "FF179C")
  )

  it should "calculate correctly using immutable" in {
    testData.map {
      case (r, g, b, expected) => RgbToHexConversion.toRgb(r, g, b) shouldEqual expected
    }
  }
}
