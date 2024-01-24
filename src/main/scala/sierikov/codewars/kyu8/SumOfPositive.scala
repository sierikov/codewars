package sierikov.codewars.kyu8

object SumOfPositive {
  def positiveSum(arr: Array[Int]): Int = arr.filter(_ > 0).sum
}
