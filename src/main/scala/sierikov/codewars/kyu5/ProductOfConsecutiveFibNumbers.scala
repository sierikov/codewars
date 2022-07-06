package sierikov.codewars.kyu5

import scala.language.implicitConversions

object ProductOfConsecutiveFibNumbers {

  def findMutable(target: Long): Array[Long] = {
    var n = 0;
    var next = 1;
    while (n * next < target) {
      next = n + next;
      n = next - n;
    }
    Array(n, next, if(n * next == target) 1 else 0);
  }

  def find(target: Long): Array[Long] = {
    val tuple = fibTuples.find(_._3 >= target).get
    val found = if (target == tuple._3) 1 else 0
    Array(tuple._1, tuple._2, found)
  }

  /** Infinite fibonacci tuples
    *  format sequence of (a, b, product of a and b)
    */
  val fibTuples: Seq[(Int, Int, Int)] = LazyList.iterate((0, 1, 1)) { case (a, b, _) => (b, a + b, b * (a + b)) }
}
