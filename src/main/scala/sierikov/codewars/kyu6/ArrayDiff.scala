package sierikov.codewars.kyu6

object ArrayDiff {
  def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int] = a.filterNot(b.contains(_))
}
