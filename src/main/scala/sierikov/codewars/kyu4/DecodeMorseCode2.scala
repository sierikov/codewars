package sierikov.codewars.kyu4

object DecodeMorseCode2 {
  import sierikov.codewars.kyu6.DecodeMorseCode.decode

  implicit class MorseString(s: String) {
    def trim0: String = s.dropWhile(_ == '0').reverse.dropWhile(_ == '0').reverse
    def asCode(basis: Int): String = if (s.length >= 3) "-" else "."
    def takeEvery(n: Int): String = s.sliding(1, n).toList.flatten.mkString
  }

  def calcBasisLength(s: String): Int = {
    val r = "1+|0+".r
    r.findAllIn(s).toList.map(_.length).min
  }

  def decodeBits(bits: String): String = {
    val bit = bits.trim0
    val timeUnit = calcBasisLength(bit)
    val dropped = if (timeUnit > 1) bit.takeEvery(timeUnit) else bit
    dropped
      .replace("111", "-")
      .replace("1", ".")
      .replace("0000000", "   ")
      .replace("000", " ")
      .replace("0", "")
  }

  def decodeMorse(msg: String): String = decode(msg)

}
