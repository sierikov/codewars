package sierikov.codewars.kyu6

object AreTheyTheSame {

  def comp(seq1: Seq[Int], seq2: Seq[Int]): Boolean = (seq1, seq2) match
    case (null, null) | (null, _) | (_, null) => false
    case (Nil, Nil)   => true
    case (a, b)       => if (a.size != b.size) false else isAllSquared(a, b)

  private def isAllSquared(seq1: Seq[Int], seq2: Seq[Int]): Boolean = {
    val sortedSeq1 = seq1.sorted
    val sortedSeq2 = seq2.sorted
    sortedSeq1.zip(sortedSeq2).map { case (x, y) => x * x == y }.reduce(_ && _)
  }
}
