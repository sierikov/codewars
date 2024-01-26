package sierikov.codewars.kyu7

object Mumbling {
  def accum(s: String): String =
    s.split("").zipWithIndex.map {
      case (char, index) => char.toUpperCase + char.toLowerCase * index
    }.mkString("-")
}
