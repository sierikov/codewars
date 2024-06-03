package sierikov.codewars.kyu5

object LastDigitOfLargeNumber {

  /**
   * All pow(n, 0) = 0, All pow(n, 1) = 1.
   * For pow(n, 2) there is a cycle 2,4,8,16,32,64,128,256,512,1024.. endings are in 2,4,8,6.
   * For pow(n, 3) endings are in 3,9,7,1.
   * this Map contains all possible endings for 0-9.
   * @note The cycle's indexing is zero-based, meaning the first position (corresponding to pow(2,1)) is at index 0.
   */
  private val endings: Map[Int, List[Int]] = Map(
    0 -> List(0),
    1 -> List(1),
    2 -> List(2, 4, 8, 6),
    3 -> List(3, 9, 7, 1),
    4 -> List(4, 6),
    5 -> List(5),
    6 -> List(6),
    7 -> List(7, 9, 3, 1),
    8 -> List(8, 4, 2, 6),
    9 -> List(9, 1)
  )

  /**
   * Calculate the last digit of a large number to the power of another large number.
   * So the  general pattern is that digit is just the (exponent)%(length of the repeating pattern)
   *
   * @example Consider pow(592, 123). Last digit of 592 is 2. Select the pattern for 2 which is 2,4,8,6.
   *          The length of the pattern is 4. Now 123%4 = 3. The 3rd number in the pattern is 8.
   *          So the last digit of pow(592,123) is 8.
   *          Full number: {{10633823966279326983230456482242756608}}
   * @param n The base number.
   * @param exponent The exponent.
   * @see https://www.codewars.com/kata/5511b2f550906349a70004e1
   * @see https://math.stackexchange.com/a/1714879
   * @return The last digit of n1 to the power of n2.
   */
  def lastDigit(n: BigInt, exponent: BigInt): BigInt =
    if (exponent == 0) 1 // Any number to the power of 0 is 1
    else
      val base = (n % 10).toInt // Get the last digit of n
      val possibilities = endings(base) // Get the possible endings for the last digit of n
      val index = ((exponent - 1) % possibilities.length).toInt // Get the index of the ending
      possibilities(index) // Return the correct ending
}
