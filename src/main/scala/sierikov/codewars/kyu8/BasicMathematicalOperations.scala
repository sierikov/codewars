package sierikov.codewars.kyu8

object BasicMathematicalOperations {
  def basicOp(op: Char, a: Int, b: Int): Int = op match {
    case '+' => a + b
    case '-' => a - b
    case '*' => a * b
    case '/' => a / b
  }
}
