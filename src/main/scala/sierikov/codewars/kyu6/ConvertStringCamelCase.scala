package sierikov.codewars.kyu6

object ConvertStringCamelCase {
  def toCamelCase(str: String): String = {
    val words = str.split("[-_]")
    words.head + words.tail.map(_.capitalize).mkString
  }
}
