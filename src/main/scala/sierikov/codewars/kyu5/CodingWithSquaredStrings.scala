package sierikov.codewars.kyu5

/**
 * Kata: https://www.codewars.com/kata/56fcc393c5957c666900024d
 */
object CodingWithSquaredStrings {

  def code(s: String): String = {
    val n = math.sqrt(s.length).ceil.toInt
    val square = n * n
    val str = s + "\u000b" * (square - s.length)

    rotateMatrixClockwise(str.toList.grouped(n).toList).map(_.mkString).mkString("\n")
  }

  def decode(s: String): String = {
    val m = rotateMatrixAnticlockwise(s.split("\n").map(_.split("").toList).toList)
    m.flatten.mkString.takeWhile(x => x != '\u000b')
  }

  private def rotateMatrixClockwise[A](m: List[List[A]]): List[List[A]] = {
    if (m.isEmpty || m.head.isEmpty) return m
    m.head.indices.map { i => m.reverseIterator.map(_(i)).toList }.toList
  }

  private def rotateMatrixAnticlockwise[A](m: List[List[A]]): List[List[A]] = {
    if (m.isEmpty || m.head.isEmpty) return m
    rotateMatrixClockwise(m.map(_.reverse)).map(_.reverse)
  }
}
