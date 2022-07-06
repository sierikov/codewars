package sierikov.codewars.kyu5

object NumberTrailingZerosFact {

  def zeros(n: Int): Int = {
    (1 to n)
      .takeWhile(Math.pow(5, _) <= n)
      .map(Math.pow(5, _).toInt)
      .map(n / _)
      .sum
  }

  def zerosRec(n: Int): Int =
    n / 5 match {
      case 0 => 0
      case x => x + zeros(x)
    }
}
