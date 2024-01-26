package sierikov.codewars.kyu7

object ShortestWord {
  def findShort(s: String): Int = s.split(" ").map(_.length).min
}
