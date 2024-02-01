package sierikov.codewars.kyu8

object ConvertNumberToReversedArrayDigits {
  def digitize(n: Long): Seq[Int] = n.toString.reverse.map(_.asDigit)
}
