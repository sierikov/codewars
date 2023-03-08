package sierikov.codewars.kyu4

object Snail {

  def snail(xs: List[List[Int]]): List[Int] = readClockWise(xs)

  /**
    * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    *
    * Algorithm: moves sequentially in a clockwise direction, starting from the top left corner of the matrix.
    * After each turn the processed elements are removed from the matrix.
    *
    * @note the `drop` was used instead of `tail` to avoid ArrayIndexOutOfBoundsException`
    *
    * @param matrix 2D array of integers
    * @return list of integers in spiral order
    */
  private def readClockWise(i: List[List[Int]], d: String = "right"): List[Int] = {
    if (i.isEmpty) return List.empty
    d match {
      case "right" => {
        val selected = i.headOption.getOrElse(List.empty[Int])
        val rest = i.drop(1)
        selected ++ readClockWise(rest, "down")
      }
      case "down" => {
        val selected = i.flatMap(_.lastOption)
        val rest = i.map(_.dropRight(1))
        selected ++ readClockWise(rest, "left")
      }
      case "left" => {
        val selected = i.last.reverse
        val rest = i.dropRight(1)
        selected ++ readClockWise(rest, "up")
      }
      case "up" => {
        val selected = i.reverse.flatMap(_.headOption)
        val rest = i.map(_.drop(1))
        selected ++ readClockWise(rest)
      }
    }
  }

}
