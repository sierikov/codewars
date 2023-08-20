package sierikov.codewars.kyu7

object DisemvowelTrolls {
  def disemvowel(str: String): String = str.replaceAll("[aeiouAEIOU]", "")
}
