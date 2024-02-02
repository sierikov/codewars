package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class BreakCamelCaseSpec extends AnyFlatSpec {

  private val tests: Seq[(String, String)] = List(
    ("helloWorld", "hello World"),
    ("camelCase", "camel Case"),
    ("breakCamelCase", "break Camel Case")
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for array: $input" in {
      BreakCamelCase.breakCamelCase(input) shouldBe expected
    }
  }
}
