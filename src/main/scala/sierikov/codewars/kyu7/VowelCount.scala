package sierikov.codewars.kyu7

object VowelCount {
  def getCount(str: String): Int = str.toLowerCase.count(_.isVowel)

  extension (c: Char)
    private def isVowel: Boolean = c match {
      case 'a' | 'e' | 'i' | 'o' | 'u' => true
      case _                           => false
    }
}
