package sierikov.codewars.kyu6

import scala.annotation.tailrec

object RomanNumeralsEncoder {

  private trait RomanNumeral(val value: Int, val symbol: String)
  private object M extends RomanNumeral(1000, "M")
  private object CM extends RomanNumeral(900, "CM")
  private object D extends RomanNumeral(500, "D")
  private object CD extends RomanNumeral(400, "CD")
  private object C extends RomanNumeral(100, "C")
  private object XC extends RomanNumeral(90, "XC")
  private object L extends RomanNumeral(50, "L")
  private object X extends RomanNumeral(10, "X")
  private object IX extends RomanNumeral(9, "IX")
  private object V extends RomanNumeral(5, "V")
  private object IV extends RomanNumeral(4, "IV")
  private object I extends RomanNumeral(1, "I")

  private val numerals: List[RomanNumeral] = List(M, CM, D, CD, C, XC, L, X, IX, V, IV, I)

  @tailrec
  def encode(n: Int, acc: String = ""): String = numerals.find(_.value <= n) match {
    case Some(numeral) => encode(n - numeral.value, acc + numeral.symbol)
    case None          => acc
  }
}
