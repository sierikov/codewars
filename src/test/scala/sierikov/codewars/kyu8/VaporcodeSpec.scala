package sierikov.codewars.kyu8

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class VaporcodeSpec extends AnyFlatSpec {

  val testData: Seq[(String, String)] = List(
    ("Lets go to the movies", "L  E  T  S  G  O  T  O  T  H  E  M  O  V  I  E  S"),
    ("Why isn't my code working?", "W  H  Y  I  S  N  '  T  M  Y  C  O  D  E  W  O  R  K  I  N  G  ?")
  )

  it should "correctly encode given strings" in {
    testData.map { case (input, expected) =>
      Vaporcode.encode(input) shouldEqual expected
    }
  }
}
