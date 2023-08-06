package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.should

class ValidParenthesesSpec extends AnyFlatSpec {

  import ValidParentheses._

  private def exec(testCases: Seq[(String, Boolean)]): Unit = testCases.foreach { (input, expected) =>
    assertResult(expected, s"\nInput: braces = $input")(validParentheses(input))
  }

  "Valid parentheses" should "return true" in {
    exec(
      Seq(
        ("()", true),
        ("()", true),
        ("((()))", true),
        ("()()()", true),
        ("(()())()", true)
      )
    )
  }

  "Unbalanced parentheses" should "return false" in {
    exec(
      Seq(
        (")(", false),
        ("()()(", false),
        ("((())", false),
        ("())(()", false),
        (")()", false),
        (")", false)
      )
    )
  }

  "Empty string" should "return true" in {
    exec(Seq(("", true)))
  }
}
