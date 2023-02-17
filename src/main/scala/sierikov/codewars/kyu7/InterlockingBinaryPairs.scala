package sierikov.codewars.kyu7

object InterlockingBinaryPairs {

  def interlockable(a: Long, b: Long): Boolean =
    !toReverseBin(a).zip(toReverseBin(b)).exists { case (a, b) =>
      a == '1' && a == b
    }

  private def toReverseBin(x: Long): Seq[Char] = x.toBinaryString.toList.reverse

}
