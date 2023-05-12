package sierikov.codewars.kyu4

import org.scalatest.funsuite.AnyFunSuite

class HumanReadableDurationFormatSuite extends AnyFunSuite {

  import HumanReadableDurationFormat._

  test("should pass basic tests") {
    assert(formatDuration(0) == "now")
    assert(formatDuration(1) == "1 second")
    assert(formatDuration(62) == "1 minute and 2 seconds")
    assert(formatDuration(120) == "2 minutes")
    assert(formatDuration(3600) == "1 hour")
    assert(formatDuration(3662) == "1 hour, 1 minute and 2 seconds")
  }
}
