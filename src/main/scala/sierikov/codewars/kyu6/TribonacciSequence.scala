package sierikov.codewars.kyu6

object TribonacciSequence {

  /**
   * Tribonacci Sequence - sum of the last 3 numbers as in Fibonacci for 2 numbers.
   * The helper function is needed to set accumulator to initial signature to have
   * the complete list in the end
   * @note We subtract 3 from n because we already have 3 numbers in the signature.
   * @param signature List of first 3 numbers
   * @param n Number of steps
   * @tparam T Numeric type
   * @return List of all numbers after n steps
   */
  def tribonacci[T: Numeric](signature: List[T], n: Int): List[T] =
    if (n <= 3) signature.take(n)
    else helper[T](n - 3, signature, signature)

  /**
   * Calculates the next number in the sequence and adds it to the accumulator.
   * Intuition: The next number is the sum of the last 3 numbers. So we sum signature,
   * add this sum to acc. Then rotate the signature by 1.
   *
   * @param n Steps left
   * @param signature List of first 3 numbers
   * @param acc Accumulator for the result list containing all numbers
   * @tparam T Numeric type
   * @return List of all numbers after n steps
   */
  @scala.annotation.tailrec
  private def helper[T: Numeric](n: Int, signature: List[T], acc: List[T]): List[T] = {
    if (n == 0) acc
    else {
      val next = signature.sum
      helper(n - 1, signature.tail :+ next, acc :+ next)
    }
  }
}
