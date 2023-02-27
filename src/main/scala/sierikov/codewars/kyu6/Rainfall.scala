package sierikov.codewars.kyu6

import scala.annotation.tailrec

object Rainfall {
  type Town = String
  type Month = String
  type DataPoint = (Month, Double)
  type Data = Map[Town, Seq[DataPoint]]

  /**
    * Convert the input string to a [[Data]].
    * The input string is in the following format:
    *
    * Example input:
    * `London: Jan 91.2, Feb 63.3\nManchester: Jan 63.3, Feb 91.2`
    *
    * Example output:
    * `Map(London -> Vector((Jan, 91.2), (Feb, 63.3)), Manchester -> Vector((Jan, 63.3), (Feb, 91.2)))`
    *
    * @param str input string
    * @return [[Data]] representation of the input string,
    *         where the key is the town name and the value is a sequence of data points
    */
  private def convertToData(str: String): Data = str
    .split("\n")
    .map(_.split(":"))
    .map { case Array(town, raw) =>
      val data: Vector[(Month, Double)] = raw
        .split(",")
        .map(_.trim.split(" "))
        .map { case Array(month, rain) => (month, rain.toDouble) }
        .toVector
      (town, data)
    }
    .toMap

  private def calcMean(data: Seq[Double]): Double = data.sum / data.size
  private def calcVariance(data: Seq[Double]): Double = {
    val m: Double = calcMean(data)
    data.map(x => math.pow(x - m, 2)).sum / data.size
  }

  def mean(town: String, str: String): Double = convertToData(str).get(town) match {
    case Some(data) => calcMean(data.map(_._2))
    case None       => -1.0
  }

  def variance(town: String, str: String): Double = convertToData(str).get(town) match {
    case Some(data) => calcVariance(data.map(_._2))
    case None       => -1.0
  }
}
