package sierikov.codewars.kyu6

object BreakCamelCase {
  def breakCamelCase(str: String): String =
    str.map(c => if (c.isUpper) s" $c" else c.toString).mkString
}
