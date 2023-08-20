package sierikov.codewars.kyu7

object EliminateIntruders {

  def eliminateUnsetBits(number: String): Long = number
    .filter(_ == '1')
    .zipWithIndex
    .map { case (value, index) => Math.pow(2, index) }
    .sum
    .toLong
}
