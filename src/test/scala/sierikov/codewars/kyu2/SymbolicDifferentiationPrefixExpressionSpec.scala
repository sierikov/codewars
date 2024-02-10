package sierikov.codewars.kyu2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*

class SymbolicDifferentiationPrefixExpressionSpec extends AnyFlatSpec {

  import SymbolicDifferentiationPrefixExpressions._

  private val simpleCases = List(
    "5" -> List("0"),
    "x" -> List("1"),
    "(+ x x)" -> List("2"),
    "(- x x)" -> List("0"),
    "(* x 2)" -> List("2"),
    "(/ x 2)" -> List("0.5"),
    "(^ x 2)" -> List("(* 2 x)"),
    "(cos x)" -> List("(* -1 (sin x))"),
    "(sin x)" -> List("(cos x)"),
    "(tan x)" -> List("(+ 1 (^ (tan x) 2))"),
    "(exp x)" -> List("(exp x)"),
    "(ln x)" -> List("(/ 1 x)")
  )

  checkCases("Simple cases", simpleCases)()

  private val nestedCases = List(
    "(+ x (+ x x))" -> List("3"),
    "(- (+ x x) x)" -> List("1"),
    "(* 2 (+ x 2))" -> List("2"),
    "(/ 2 (+ 1 x))" -> List("(/ -2 (^ (+ 1 x) 2))"),
    "(cos (+ x 1))" -> List("(* -1 (sin (+ x 1)))"),
    "(sin (+ x 1))" -> List("(cos (+ x 1))"),
    "(sin (* 2 x))" -> List("(* 2 (cos (* 2 x)))"),
    "(tan (* 2 x))" -> List("(* 2 (+ 1 (^ (tan (* 2 x)) 2)))"),
    "(exp (* 2 x))" -> List("(* 2 (exp (* 2 x)))"),
    "(cos (* 2 x))" -> List("(* 2 (* -1 (sin (* 2 x))))", "(* -2 (sin (* 2 x)))"),
    "(^ (sin x) 3)" -> List(
      "(* (* 3 (^ (sin x) 2)) (cos x))",
      "(* (cos x) (* 3 (^ (sin x) 2)))",
      "(* (* (^ (sin x) 2) 3) (cos x))",
      "(* (cos x) (* (^ (sin x) 2) 3))"
    )
  )

  checkCases("Nested cases", nestedCases)()

  private val secondCases = List(
    "(sin x)" -> List("(* -1 (sin x))"),
    "(exp x)" -> List("(exp x)"),
    "(^ x 3)" -> List("(* 3 (* 2 x))", "(* 6 x)")
  )

  checkCases("Second derivation", secondCases)(s => diff(diff(s)))

  def checkCases(name: String, cases: List[(String, List[String])])(d: String => String = diff): Unit =
    behavior.of(name)
    cases.foreach { case (expr, answers) => checkCase(expr, answers)(d) }

  def checkCase(expr: String, answers: List[String])(d: String => String = diff): Unit =
    it should s"return ${answers.mkString(" or ")} for $expr" in {
      val result = d(expr)
      answers should contain(result)
    }

}
