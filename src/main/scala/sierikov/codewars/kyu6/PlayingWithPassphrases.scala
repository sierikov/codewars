package sierikov.codewars.kyu6

object PlayingWithPassphrases {

  private val alphabetSize = 26

  def playPass(s: String, n: Int): String = {
    s.map {
      case s if s.isLetter => circularShift(n, s)
      case s if s.isDigit  => complement9(s)
      case s               => s
    }.zipWithIndex
      .map {
        case (s, i) if i % 2 == 0 => s.toUpper
        case (s, _)               => s.toLower
      }
      .reverse
      .mkString
  }

  private def circularShift(shift: Int, s: Char) = {
    val allowedShift = shift % alphabetSize
    val shifted = s + allowedShift
    if (shifted > 'Z') (shifted - alphabetSize).toChar else shifted.toChar
  }

  private def complement9(s: Char): Char = (9 - s.asDigit).toString.head
}
