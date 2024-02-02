package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class FindMissingLetterSpec extends AnyFlatSpec {
  private val tests: Seq[(Array[Char], Char)] = List(
    (Array('a', 'b', 'c', 'd', 'f'), 'e'),
    (Array('O', 'Q', 'R', 'S'), 'P'),
    (Array('x', 'z'), 'y')
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for array ${input.mkString(",")}" in {
      FindMissingLetter.findMissingLetter(input) shouldBe expected
    }
  }
}
