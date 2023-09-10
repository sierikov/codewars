package sierikov.codewars.kyu7

object SquareEveryDigit {
  def squareDigits(n: Int): Int = {
    n.toString.map(_.asDigit).map(x => x * x).mkString.toInt
  }
}
