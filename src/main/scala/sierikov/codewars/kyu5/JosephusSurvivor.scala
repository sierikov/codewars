package sierikov.codewars.kyu5

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object JosephusSurvivor {

  def calcMath(amount: Int, step: Int): Int =
    if (amount == 1) 1
    else (calcMath(amount - 1, step) + step - 1) % amount + 1

  def calc(amount: Int, step: Int): Int = helper(generateList(amount), step).last

  def generateList(amount: Int): ArrayBuffer[Int] = (1 to amount).to(ArrayBuffer)

  /** Returns the index based on current position in the array.
    *
    * For [1,2,3,4,5] and index = 1, step = 3 should return 3<br>
    * For [1,2,3,4,5] and index = 4, step = 3 should return 2
    *
    * @param size how many candidates are
    * @param index current index in the array
    * @param step size of the step
    * @return current element
    */
  def getNextIndex(size: Int, index: Int, step: Int): Int = (index + step - 1) % size

  @tailrec
  def helper(array: ArrayBuffer[Int], step: Int, current: Int = 0, result: Vector[Int] = Vector.empty): Vector[Int] =
    if (array.isEmpty) result
    else {
      val nextIndex = getNextIndex(array.length, current, step)
      val element = array(nextIndex)
      array.remove(nextIndex)
      helper(
        array = array,
        step = step,
        current = nextIndex,
        result = result :+ element
      )
    }

}
