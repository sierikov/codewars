package sierikov.codewars.kyu8

object LarioAndMuigiPipeProblem {

  def pipeFix(nums: Seq[Int]): Seq[Int] = {
    val min = nums.min
    val max = nums.max
    min to max
  }
}
