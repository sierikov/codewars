package sierikov.codewars.kyu2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*

class SymbolicDifferentiationPrefixExpressionSpec extends AnyFlatSpec {

  import SymbolicDifferentiationPrefixExpressions._

  private val parseCases = List(
    "5" -> Value(5),
    "x" -> Variable,
    "(+ x x)" -> Add(Variable, Variable),
    "(- x x)" -> Sub(Variable, Variable),
    "(* x 2)" -> Mul(Variable, Value(2)),
    "(/ x 2)" -> Div(Variable, Value(2)),
    "(^ x 2)" -> Pow(Variable, Value(2)),
    "(cos x)" -> Cos(Variable),
    "(sin x)" -> Sin(Variable),
    "(tan x)" -> Tan(Variable),
    "(exp x)" -> Exp(Variable),
    "(ln x)" -> Ln(Variable),
    // Complex cases
    "(+ x (+ x x))" -> Add(Variable, Add(Variable, Variable)),
    "(- (+ x x) x)" -> Sub(Add(Variable, Variable), Variable),
    "(* 2 (+ x 2))" -> Mul(Value(2), Add(Variable, Value(2))),
    "(/ 2 (+ 1 x))" -> Div(Value(2), Add(Value(1), Variable)),
    "(^ (sin x) 3)" -> Pow(Sin(Variable), Value(3))
  )

  behavior.of("Parser")
  parseCases.foreach { case (expr, expected) =>
    it should s"return $expected for $expr" in {
      Expr.parse(expr) shouldEqual expected
    }
  }

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
