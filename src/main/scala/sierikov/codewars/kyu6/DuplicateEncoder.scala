package sierikov.codewars.kyu6

object DuplicateEncoder {
  def duplicateEncode(str: String): String = {
    val lowerCaseStr = str.toLowerCase
    lowerCaseStr.map(c => if lowerCaseStr.count(_ == c) > 1 then ')' else '(')
  }
}
