package sierikov.codewars.kyu4

import scala.annotation.tailrec

/**
 * Calculate the maximum sum of a subarray of a given array of integers.
 * Uses Kadane's algorithm with tail recursion.
 *
 * @see https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * @see kata https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
 */
object MaximumSubarraySum {
  def sequence(arr: Array[Int]): Int = helper(arr, 0)

  @tailrec
  private def helper(arr: Array[Int], max: Int = Int.MinValue, current: Int = 0): Int = {
    if (arr.isEmpty) max
    else {
      val localMax = Math.max(arr.head, current + arr.head)
      val globalMax = Math.max(max, localMax)
      helper(arr.tail, globalMax, localMax)
    }
  }
}
