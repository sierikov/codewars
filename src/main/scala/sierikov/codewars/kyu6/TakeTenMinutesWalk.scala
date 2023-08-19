package sierikov.codewars.kyu6

object TakeTenMinutesWalk {
  def isValidWalk(walk: Seq[Char]): Boolean = walk.length match
    case 10 => walk.foldLeft((0, 0))(walkReducer) == (0, 0)
    case _  => false

  private def walkReducer(acc: (Int, Int), direction: Char): (Int, Int) = direction match
    case 'n' => (acc._1 + 1, acc._2)
    case 's' => (acc._1 - 1, acc._2)
    case 'e' => (acc._1, acc._2 + 1)
    case 'w' => (acc._1, acc._2 - 1)
}
