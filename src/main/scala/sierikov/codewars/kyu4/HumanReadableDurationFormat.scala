package sierikov.codewars.kyu4

object HumanReadableDurationFormat {

  /**
   * Format given duration in seconds to human readable format.
   * @example formatDuration(62) should return "1 minute and 2 seconds"
   * @param seconds duration in seconds
   * @return human readable format of duration
   */
  def formatDuration(seconds: Int): String = {
    val second = 1
    val minute = 60 * second
    val hour = 60 * minute
    val day = 24 * hour
    val year = 365 * day

    List((year, "year"), (day, "day"), (hour, "hour"), (minute, "minute"), (second, "second"))
      .foldLeft((seconds, List.empty[String])) { case ((rest, acc), (unit, name)) =>
        val (newRest, newAcc) = if (rest >= unit) (rest % unit, format(rest / unit, name) :: acc) else (rest, acc)
        (newRest, newAcc)
      } match {
      case (_, Nil)          => "now"
      case (_, head :: Nil)  => head
      case (_, head :: tail) => tail.reverse.mkString(", ") + " and " + head
    }
  }

  private def format(seconds: Int, unit: String): String = {
    if (seconds == 0) return ""
    if (seconds == 1) return s"1 $unit"
    s"$seconds ${unit}s"
  }

}
