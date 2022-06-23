package sierikov.codewars.kyu4

object MatrixDeterminant {

  type Grid = Array[Array[Int]]

  def determinant(matrix: Grid): Int = {
    matrix.length match {
      case 1 => matrix(0)(0) // 1x1 matrix
      case 2 => determinant2(matrix) // 2x2
      case _ => laplace(matrix)
    }
  }

  def determinant2(matrix: Grid): Int =
    matrix(0)(0) * matrix(1)(1) - matrix(0)(1) * matrix(1)(0)

  def determinant3(matrix: Grid): Int = {
    val a = matrix(0)(0)
    val b = matrix(0)(1)
    val c = matrix(0)(2)
    val d = matrix(1)(0)
    val e = matrix(1)(1)
    val f = matrix(1)(2)
    val g = matrix(2)(0)
    val h = matrix(2)(1)
    val i = matrix(2)(2)
    a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g)
  }

  def laplace(matrix: Grid): Int = {
    val size = matrix.length

    if (size == 3) return determinant3(matrix)

    var det = 0
    for {
      j <- 0 until size
    } {
      val current = matrix(0)(j)
      val littleMatrix = reduceMatrix(matrix, j)
      val parity = if ((j & 1) == 0) +1 else -1
      det = parity * current * laplace(littleMatrix) + det
    }

    det
  }

  def reduceMatrix(matrix: Grid, column: Int): Array[Array[Int]] =
    matrix
      .drop(1)
      .map(row =>
        row.zipWithIndex
          .filter { case (_, index) => index != column }
          .map { case (value, _) => value }
      )
}
