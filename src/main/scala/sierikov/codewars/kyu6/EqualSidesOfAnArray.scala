package sierikov.codewars.kyu6

object EqualSidesOfAnArray {
  def findEvenIndex(arr: Array[Int]): Int =
    (for {
      i <- arr.indices
      if arr.take(i).sum == arr.drop(i + 1).sum
    } yield i).headOption.getOrElse(-1)
}
