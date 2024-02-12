package sierikov.codewars.kyu2

object SymbolicDifferentiationPrefixExpressions {

  /**
   * Representing expressions of any depth.
   * @note Expressions are single variable expressions using x as the variable.
   */
  sealed trait Expr {
    def simplify: Expr
    def diff: Expr
    def print: String
  }
  object Expr {
    def splitExpr(text: String): (String, String) = {
      if (text.isEmpty) ("", "")
      else if (text.startsWith("(")) splitParenthesesExpr(text)
      else if (text.contains('(')) splitAtFirstParentheses(text)
      else splitAtFirstSpace(text)
    }

    def splitParenthesesExpr(text: String): (String, String) = {
      var depth = 0
      val i = text.indexWhere { c =>
        if (c == '(') depth += 1
        else if (c == ')') depth -= 1
        depth == 0
      }
      (text.slice(0, i + 1).trim, text.drop(i + 1).trim)
    }

    def splitAtFirstParentheses(text: String): (String, String) = {
      val head = text.takeWhile(_ != '(')
      (head.trim, text.drop(head.length).trim)
    }

    def splitAtFirstSpace(text: String): (String, String) = {
      val arr = text.split(" ", 2)
      (arr(0), arr.lift(1).getOrElse(""))
    }

    def parseBinaryOp(text: String, f: (Expr, Expr) => Expr): Expr = {
      val (arg0, arg1) = splitExpr(text)
      f(parse(arg0), parse(arg1))
    }

    def parse(text: String): Expr = {
      text match {
        case t if t.startsWith("(") && t.endsWith(")") => parse(t.slice(1, t.length - 1))
        case t =>
          val parts = t.split(" ", 2)
          parts(0) match {
            case "+"   => parseBinaryOp(parts(1), Add.apply)
            case "-"   => parseBinaryOp(parts(1), Sub.apply)
            case "*"   => parseBinaryOp(parts(1), Mul.apply)
            case "/"   => parseBinaryOp(parts(1), Div.apply)
            case "^"   => parseBinaryOp(parts(1), Pow.apply)
            case "cos" => Cos(parse(parts(1)))
            case "sin" => Sin(parse(parts(1)))
            case "tan" => Tan(parse(parts(1)))
            case "exp" => Exp(parse(parts(1)))
            case "ln"  => Ln(parse(parts(1)))
            case "x"   => Variable
            case _     => Value(parts(0).toDouble)
          }
      }
    }
  }

  case object Variable extends Expr {
    override def simplify: Expr = this
    override def diff: Expr = Value(1)
    override def print: String = "x"
  }

  case class Value(v: Double) extends Expr {
    override def simplify: Expr = this
    override def diff: Expr = Value(0)
    override def print: String = v match {
      case v if v.isValidInt => v.toInt.toString
      case _                 => v.toString
    }
  }

  sealed abstract class Fn(f: Expr) extends Expr
  sealed abstract class Op(l: Expr, r: Expr) extends Expr

  case class Cos(e: Expr) extends Fn(e) {
    override def simplify: Expr = Cos(e.simplify)
    override def diff: Expr = Mul(e.simplify.diff, Mul(Value(-1), Sin(e.simplify))) // cos(2x) -> -2sin(2x)
    override def print = s"(cos ${e.print})"
  }

  case class Sin(e: Expr) extends Fn(e) {
    override def simplify: Expr = Sin(e.simplify)
    override def diff: Expr = Mul(e.simplify.diff, Cos(e.simplify)) // sin(2x) -> 2cos(2x)
    override def print = s"(sin ${e.print})"
  }

  /**
   * The diff of the tan function is {{{(tan x)' = 1/cos^2(x)}}}.
   * However, the expected diff of the tan function in the kata is {{{(tan x)' = 1 + tan^2(x)}}}.
   *
   * @see discussion [[https://www.codewars.com/kata/584daf7215ac503d5a0001ae/discuss#6066439f42a04500444ec1f6]]
   * @see [[https://en.wikipedia.org/wiki/Differentiation_of_trigonometric_functions]]
   */
  case class Tan(e: Expr) extends Fn(e) {
    override def simplify: Expr = Tan(e.simplify)
    override def diff: Expr =
      Mul(e.simplify.diff, Add(Value(1), Pow(Tan(e.simplify), Value(2)))) // tan(2x) -> 1 + tan^2(2x)
    override def print = s"(tan ${e.print})"
  }

  case class Exp(e: Expr) extends Fn(e) {
    override def simplify: Expr = this
    override def diff: Expr = Mul(e.simplify.diff, Exp(e.simplify)) // exp(2x) -> 2exp(2x)
    override def print = s"(exp ${e.print})"
  }

  case class Ln(e: Expr) extends Fn(e) {
    override def simplify: Expr = Ln(e.simplify)
    override def diff: Expr = Mul(e.simplify.diff, Div(Value(1), e.simplify))
    override def print = s"(ln ${e.print})"
  }

  case class Add(l: Expr, r: Expr) extends Op(l, r) {

    override def simplify: Expr = (l, r) match {
      case (Value(lv), Value(rv)) => Value(lv + rv).simplify
      case (Value(0), _)          => r.simplify
      case (_, Value(0))          => l.simplify
      case _                      => Add(l.simplify, r.simplify)
    }

    override def diff: Expr = Add(l.simplify.diff, r.simplify.diff)
    override def print: String = s"(+ ${l.print} ${r.print})"
  }

  case class Sub(l: Expr, r: Expr) extends Op(l, r) {

    override def simplify: Expr = (l, r) match {
      case (Value(lv), Value(rv)) => Value(lv - rv).simplify
      case (Value(0), _)          => r.simplify
      case (_, Value(0))          => l.simplify
      case _                      => Sub(l.simplify, r.simplify)
    }

    override def diff: Expr = Sub(l.simplify.diff, r.simplify.diff)
    override def print: String = s"(- ${l.print} ${r.print})"
  }

  case class Mul(l: Expr, r: Expr) extends Op(l, r) {

    override def simplify: Expr = (l, r) match {
      case (Value(lv), Value(rv)) => Value(lv * rv).simplify
      case (Value(0), _)          => Value(0)
      case (_, Value(0))          => Value(0)
      case (Value(1), _)          => r.simplify
      case (_, Value(1))          => l.simplify
      case _                      => Mul(l.simplify, r.simplify)
    }

    /** 
     * The diff of the multiplication function is 
     * {{{(f * g)' = f' * g + g' * f}}} 
     */
    override def diff: Expr = Add(Mul(l.simplify, r.simplify.diff), Mul(r.simplify, l.simplify.diff))
    override def print: String = s"(* ${l.print} ${r.print})"
  }

  case class Div(l: Expr, r: Expr) extends Op(l, r) {

    override def simplify: Expr = (l, r) match {
      case (Value(lv), Value(rv)) => Value(lv / rv).simplify
      case (Value(0), _)          => Value(0)
      case (l, Value(1))          => l.simplify
      case _                      => Div(l.simplify, r.simplify)
    }

    /** 
     * The diff of the division function is 
     * {{{(f / g)' = (f' * g - g' * f) / g^2}}}
     */
    override def diff: Expr =
      Div(Sub(Mul(l.simplify.diff, r.simplify), Mul(r.diff.simplify, l.simplify)), Pow(r.simplify, Value(2)))
    override def print: String = s"(/ ${l.print} ${r.print})"
  }

  /**
   * Due Kata test limitations we need to handle diff for
   * (expr, value) and (value, expr) cases separately.
   *
   * @see [[https://www.codewars.com/kata/584daf7215ac503d5a0001ae/discuss#63d8fd8f9b2a06001cb17e26]]
   */
  case class Pow(l: Expr, r: Expr) extends Op(l, r) {

    override def simplify: Expr = (l, r) match {
      case (Value(lv), Value(rv)) => Value(math.pow(lv, rv)).simplify
      case (Value(0), _)          => Value(0)
      case (_, Value(0))          => Value(1)
      case (Value(1), _)          => Value(1)
      case (_, Value(1))          => l.simplify
      case _                      => Pow(l.simplify, r.simplify)
    }
    
    override def diff: Expr = (l, r) match {
      // (^ (sin x) 3) -> (* 3 (^ (sin x) 2) (cos x))
      case (l, Value(rv)) => Mul(Mul(Value(rv), Pow(l.simplify, Value(rv - 1))), l.simplify.diff)
      case _ =>
        val part1 = Pow(l.simplify, Sub(r.simplify, Value(1))) // f^(g-1)
        val part2 = Mul(r.simplify.diff, Ln(l.simplify)) // g' * ln(f)
        val part3 = Mul(part2, l) // g' * ln(f) * f
        val part4 = Mul(r.simplify, l.simplify.diff) // g * f'
        val part5 = Add(part3, part4) // g' * ln(f) * f + g * f'
        Mul(part5, part1) // Final result: f^(g-1) * (g' * ln(f) * f + g * f')
    }

    override def print: String = s"(^ ${l.print} ${r.print})"
  }

  /**
   * Simplify the given expression until it can't be simplified anymore.
   * @param expr the expression to simplify
   * @return the simplified expression
   */
  def diff(expr: String): String = {
    val parsedExpr = Expr.parse(expr)
    var res = parsedExpr.simplify.diff

    while (res.simplify != res) {
      res = res.simplify
    }
    res.print
  }

}
