package sierikov.codewars.kyu6

object FindTheOddInt {

  def findOdd(xs: Seq[Int]): Int = xs
    .filter(x => xs.count(_ == x) % 2 != 0)
    .max

}
