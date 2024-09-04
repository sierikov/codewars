package sierikov.codewars.kyu5

/**
 * Kata: https://www.codewars.com/kata/5270d0d18625160ada0000e4
 */
object GreedIsGood {

  def score(dice: List[Int]): Int =
    dice
      .groupBy(identity)
      .map { case (dice, occurrences) =>
        val size = occurrences.size
        val triplets = size / 3
        val remainders = size % 3

        getTripleScore(dice) * triplets + getScore(dice) * remainders
      }
      .sum

  private def getTripleScore(n: Int) = n match
    case 1          => 1000
    case n if n > 6 => throw IllegalArgumentException(s"Dice is limited to 6, but got $n")
    case n          => n * 100

  private def getScore(n: Int) = n match
    case 1 => 100
    case 5 => 50
    case _ => 0

}
