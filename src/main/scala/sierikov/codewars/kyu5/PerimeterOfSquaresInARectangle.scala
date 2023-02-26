package sierikov.codewars.kyu5

object PerimeterOfSquaresInARectangle {

  /**
    * Sum of first n Fibonacci numbers
    * @param n number of Fibonacci numbers to sum
    * @param a first Fibonacci number
    * @param b second Fibonacci number
    * @param acc accumulator for sum
    * @return sum of first n Fibonacci numbers
    */
  @scala.annotation.tailrec
  private def fibonacciSum(n: BigInt, a: BigInt = 0, b: BigInt = 1, acc: BigInt = 0): BigInt =
    if (n == 0) acc
    else fibonacciSum(n - 1, b, a + b, acc + a)

  /**
    * Calculates perimeter of squares in a rectangle
    * @param n number of squares in a rectangle
    * @return total perimeter of a rectangle
    */
  def perimeter(n: BigInt): BigInt =
    fibonacciSum(n + 2) * 4

}
