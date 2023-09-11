package sierikov.codewars.kyu5

object HashTagGenerator {
  def generateHashtag(str: String): String = {
    val result = "#" + str.split(" ").map(_.toLowerCase.capitalize).mkString
    if (result.length > 140 || result.length == 1) "" else result
  }
}
