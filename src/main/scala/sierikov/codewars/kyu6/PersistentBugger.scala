package sierikov.codewars.kyu6

object PersistentBugger {
  @scala.annotation.tailrec
  def persistence(n: Int, counter: Int = 0): Int = {
    if (n < 10) counter
    else persistence(n.toString.map(_.asDigit).product, counter + 1)
  }
}
