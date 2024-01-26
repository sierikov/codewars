package sierikov.codewars.kyu7

object GetMiddleChar {
  def middle(s: String): String = {
    val l = s.length
    if (l % 2 == 0)
      s.substring(l / 2 - 1, l / 2 + 1)
    else
      s.substring(l / 2, l / 2 + 1)
  }
}
