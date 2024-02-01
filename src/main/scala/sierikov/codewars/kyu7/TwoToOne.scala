package sierikov.codewars.kyu7

object TwoToOne {
  def longest(s1: String, s2: String): String = (s1 ++ s2).distinct.sorted
}
