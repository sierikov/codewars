package sierikov.codewars.kyu6

object FindParityOutlier {
  def findOutlier(integers: List[Int]): Int = {
    val even = integers.filter(_ % 2 == 0)
    val odd = integers.filter(_ % 2 != 0)

    if (even.length > odd.length) odd.head
    else if (even.length < odd.length) even.head
    else throw new IllegalArgumentException("No outlier can be found")
  }
}
