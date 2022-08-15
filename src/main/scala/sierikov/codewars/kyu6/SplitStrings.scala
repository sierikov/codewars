package sierikov.codewars.kyu6

object SplitStrings {

  def solution(s: String): List[String] = {
    val str = if (s.length % 2 != 0) s + '_' else s
    str.sliding(2, 2).toList
  }

}
