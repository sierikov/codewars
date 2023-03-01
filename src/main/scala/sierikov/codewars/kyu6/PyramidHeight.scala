package sierikov.codewars.kyu6

object PyramidHeight {
  def pyramidHeight(n: Int): Int =
    (1 to n)
      .map(squarePyramid)
      .count(_ <= n)

  /** Calculates how many blocks are in a pyramid with n layers
    * @see [[https://en.wikipedia.org/wiki/Square_pyramidal_number]]
    *
    * @param n number of layers
    * @return number of blocks
    */
  private def squarePyramid(n: Int): Double =
    (2 * Math.pow(n, 3) + 3 * Math.pow(n, 2) + n) / 6

}
