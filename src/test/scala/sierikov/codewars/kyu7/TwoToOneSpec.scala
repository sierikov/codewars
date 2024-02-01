package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class TwoToOneSpec extends AnyFlatSpec {

  private val tests = List(
    ("aretheyhere", "yestheyarehere", "aehrsty"),
    ("loopingisfunbutdangerous", "lessdangerousthancoding", "abcdefghilnoprstu"),
    ("inmanylanguages", "theresapairoffunctions", "acefghilmnoprstuy")
  )

  tests.foreach { case (a, b, expected) =>
    it should s"return $expected for ${a.take(5)}.. and ${b.take(5)}" in {
      TwoToOne.longest(a, b) shouldBe expected
    }
  }
}
