package sierikov.codewars.kyu3

import scala.annotation.tailrec
import scala.collection.SeqView.Sorted
import scala.collection.mutable

object AlphabeticAnagrams {

  /**
   * Calculates rank of given string in the list of all alphabetic permutations of its letters
   * Algorithm:
   *  - Iterate over all letters in the string
   *  - For each letter iterate over all letters after it
   *  - If letter after is less than current letter, then it is in wrong order
   *  - Calculate amount of permutations of letters before and after wrong letter
   *  - Add amount of permutations to rank
   * Example: {{{"ABAB" -> 2}}}
   * Explanation: {{{
   * AABB
   * ABAB
   * ABBA
   * BAAB
   * BABA
   * BBAA
   * }}}
   *
   * @param s string to calculate rank for
   * @return rank of given string
   */
  def listPosition(s: String): BigInt = {
    val arr = s.toCharArray.toIndexedSeq
    var rank = BigInt(1)

    for (i <- arr.indices) {

      val processed = mutable.Set[Char]()

      for (j <- i + 1 until arr.length) {
        val notAlphabeticalOrder = arr(j) < arr(i)
        val notProcessed = !processed.contains(arr(j))
        if (notAlphabeticalOrder && notProcessed) {
          processed.add(arr(j))
          val lettersBefore = arr.slice(i, j)
          val lettersAfter = arr.slice(j + 1, arr.length)
          rank += calcPermutations(lettersBefore ++ lettersAfter)
        }
      }
    }
    rank
  }

  /**
   * Calculates amount of permutations of given sequence
   * Formula: n! / (n1! * n2! * ... * nk!)
   * Example: "abba" -> 4! / (2! * 2!) = 6
   *
   * @see [[https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets]]
   *
   * */
  private def calcPermutations(seq: Seq[Char]): BigInt = {
    val grouped = seq.groupBy(identity)
    val factorials = grouped.values.map(v => factorial(v.length))
    factorial(seq.length) / factorials.product
  }

  @tailrec
  private def factorial(n: BigInt, acc: BigInt = 1): BigInt =
    if n <= 0 then acc
    else factorial(n - 1, n * acc)
}
