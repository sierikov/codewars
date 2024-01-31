package sierikov.codewars.kyu7

object BSSumOfNumbers {
  def getSum(a: Int, b: Int): Int = { if (a < b) a to b else b to a }.sum
}
