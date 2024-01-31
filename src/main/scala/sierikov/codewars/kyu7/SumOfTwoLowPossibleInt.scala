package sierikov.codewars.kyu7

object SumOfTwoLowPossibleInt {
  def sumTwoSmallest(numbers: List[Int]): Int = numbers.sorted.take(2).sum
}
