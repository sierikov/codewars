package sierikov.codewars.kyu6

object CountingDuplicates {
  def duplicateCount(str: String): Int =
    str.toLowerCase.split("").groupBy(identity).map(_._2.length).count(_ >= 2)
}
