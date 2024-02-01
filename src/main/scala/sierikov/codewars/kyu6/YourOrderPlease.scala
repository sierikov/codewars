package sierikov.codewars.kyu6

object YourOrderPlease {
  def order(str: String): String = {
    str.split(" ").sortBy(_.filter(_.isDigit)).mkString(" ")
  }
}
