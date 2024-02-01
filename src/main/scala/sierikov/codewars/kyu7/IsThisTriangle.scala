package sierikov.codewars.kyu7

object IsThisTriangle {

  def isTriangle(a: Int, b: Int, c: Int): Boolean = {
    a + b > c && a + c > b && b + c > a
  }
}
