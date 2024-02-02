package sierikov.codewars.kyu6

object FindMissingLetter {

  /**
   * Finds the missing letter in the array of letters.
   * Intuition: 
   * 1. Create a range of letters from 'a' to 'z'
   * 2. Take the slice of the range from the first and last letters of the array
   * 3. Find the difference between the slice and the array
   * @see [[https://www.codewars.com/kata/5839edaa6754d6fec10000a2]]
   * @param array array of letters
   * @return missing letter
   */
  def findMissingLetter(array: Array[Char]): Char = {
    val alphabet = 'a' to 'z'
    val start = alphabet.indexOf(array.head.toLower)
    val end = alphabet.indexOf(array.last.toLower)
    val missing = alphabet.slice(start, end).toSet.diff(array.map(_.toLower).toSet).head
    if (array.head.isUpper) missing.toUpper else missing
  }
}
