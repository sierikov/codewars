package sierikov.codewars.kyu5

object HelpYourGranny {

  def takeOnlyRelevantDistances(
      friends: List[String],
      towns: List[(String, String)],
      distances: Map[String, Double]
  ): Seq[Double] =
    friends
      .flatMap(friend => towns.find { case (person, _) => person == friend })
      .map { case (_, town) => distances(town) }

  def findSidePythagoras(hypotenuse: Double, side: Double): Double = {
    val s: Double = Math.pow(side, 2d)
    val h: Double = Math.pow(hypotenuse, 2d)
    Math.sqrt(Math.round(Math.abs(h - s)).toDouble)
  }

  def tour(friends: List[String], towns: List[(String, String)], distances: Map[String, Double]): Int = {
    val distance: Seq[Double] = takeOnlyRelevantDistances(friends, towns, distances)

    val path = distance
      .sliding(2, 1)
      .map { case List(current, next) => findSidePythagoras(current, next) }
      .sum

    (path + distance.head + distance.last).toInt
  }

}
