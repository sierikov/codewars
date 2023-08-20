package sierikov.codewars.kyu7

object ExesAndOhs {

  def xo(str: String): Boolean = {
    val s = str.toLowerCase
    s.count(_ == 'x') == s.count(_ == 'o')
  }

}
