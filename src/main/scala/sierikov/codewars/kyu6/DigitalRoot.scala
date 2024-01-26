package sierikov.codewars.kyu6

object DigitalRoot {

  @scala.annotation.tailrec
  def digitalRoot(n: Int): Int = {
    val temp = n.toString.map(_.toString.toInt).sum
    if (temp > 9) digitalRoot(temp) else temp
  }
}
