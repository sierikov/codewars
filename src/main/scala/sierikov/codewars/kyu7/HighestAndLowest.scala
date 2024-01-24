package sierikov.codewars.kyu7

object HighestAndLowest {
  def highAndLow(numbers: String): String = {
    val numbersList = numbers.split(" ").map(_.toInt)
    s"${numbersList.max} ${numbersList.min}"
  }
}
