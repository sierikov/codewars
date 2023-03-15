/**
* @see [[https://www.codewars.com/kata/5264d2b162488dc400000001]]
*/
object Codewars {
  def spinWords(sentence: String): String = sentence
    .split(" ")
    .map {
      case s: String if s.length() >= 5 => s.reverse
      case s: String                    => s
    }
    .mkString(" ")
}
