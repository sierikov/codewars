package sierikov.codewars.kyu3

import java.math.BigInteger
import java.math.BigInteger.{ONE, ZERO}

object FabergeEasterEgg {

  /**
   * Use binomial coefficient to calculate the number of ways to distribute the tries among the eggs.
   * The number of ways to distribute the tries among the eggs is the sum of the binomial coefficients.
   * Applied dynamic programming to pass the performance tests.
   * @note Using BigIntegers due kata requirements.
   * @note Using cumulative sum of coefficient to avoid recalculating the same values.
   * @see [[https://en.wikipedia.org/wiki/Binomial_coefficient]]
   */
  def height(eggs: BigInteger, tries: BigInteger): BigInteger = {
    if (eggs == ZERO || tries == ZERO) return ZERO

    /**
     * Having more eggs than tries doesn't provide any additional advantage.
     * The limiting factor in determining the maximum height is the number of tries, not the number of eggs.
     */
    val numberOfEggs = if (eggs.compareTo(tries) > 0) BigInt(tries) else BigInt(eggs)

    var currentEgg = ONE
    var remainingFloors = ONE
    var result = ZERO

    while (currentEgg.compareTo(numberOfEggs) <= 0) {
      val remainTries = tries.add(ONE).subtract(currentEgg)
      val newFloors =
        remainingFloors.multiply(remainTries).divide(currentEgg) // evenly distribute the tries among the eggs

      remainingFloors = newFloors
      currentEgg = currentEgg.add(ONE)
      result = result.add(newFloors)
    }

    result
  }
}
