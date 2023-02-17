package sierikov.codewars.kyu5

/**
  * Solution to Move all zeros to the end. kata.
  * https://www.codewars.com/kata/52597aa56021e91c93000cb0
  * 
  * Due to the bugs in the kata tests for Scala, this kata was solved with JavaScript.
  */
object MoveZeroToEnd {

  def move(lst: List[Int]): List[Int] =
    lst.partition(_ == 0) match {
      case (Nil, _)      => lst
      case (zeros, rest) => rest ::: zeros
    }

}
