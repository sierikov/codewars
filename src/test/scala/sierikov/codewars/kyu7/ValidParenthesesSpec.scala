package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.should

class ValidParenthesesSpec extends AnyFlatSpec {

  import ValidParentheses._

  private def exec(testCases: Seq[(String, Boolean)]): Unit = testCases.foreach { (input, expected) =>
    assertResult(expected, s"\nInput: braces = $input")(validParentheses(input))
  }

  it should "return true on valid parentheses" in {
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

  it should "return false on unbalanced parenthese" in {
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

  it should "return true for empty" in {
    exec(Seq(("", true)))
  }
}
