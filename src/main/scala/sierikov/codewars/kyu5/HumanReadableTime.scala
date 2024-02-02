package sierikov.codewars.kyu5

object HumanReadableTime {

  /**
   * Function converts seconds to human readable time.
   * The intuition is to divide seconds by 3600 to get hours, then divide the remainder by 60 to get minutes,
   * and the remainder of that by 60 to get seconds.
   *
   * @param sec - number of seconds
   * @see kata [[https://www.codewars.com/kata/52685f7382004e774f0001f7]]
   * @example given 86399 seconds, returns "23:59:59"
   *          1. 86399 / 3600 = 23 hours
   *          2. 86399 % 3600 = 3599 seconds (left)
    *         3. 3599 / 60 = 59 minutes
   *          4. 3599 % 60 = 59 seconds (left)
   * @return String in format "HH:MM:SS"
   */
  def makeReadable(sec: Int): String = {
    val hours = sec / 3600
    val leftSeconds = sec % 3600
    val minutes = leftSeconds / 60
    val seconds = leftSeconds % 60
    f"$hours%02d:$minutes%02d:$seconds%02d"
  }
}
