package sierikov.codewars.kyu7

object JadenCasingStrings {
  implicit class StringExtensions(s: String) {
    def uppercaseFirstLetter: String = s.toList match
      case head :: tail => s"${head.toUpper}${tail.mkString.toLowerCase}"
      case _ => "illegal"

    def toJadenCase: String = s.split(" ").map(_.uppercaseFirstLetter).mkString(" ")
  }
}
