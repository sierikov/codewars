package sierikov.codewars.kyu7

object Isogram {
  def isIsogram(s: String): Boolean =
    s.toLowerCase.distinct.length == s.length
}
