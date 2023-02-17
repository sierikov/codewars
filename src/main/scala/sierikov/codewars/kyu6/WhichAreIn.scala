package sierikov.codewars.kyu6

object WhichAreIn {
  def inArray(array1: Array[String], array2: Array[String]): Array[String] = {
    array1
      .filter(sub => array2.map(str => str.contains(sub)).reduce(_ || _))
      .sorted
      .distinct
  }
}
