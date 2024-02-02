package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class HumanReadableTimeSpec extends AnyFlatSpec {

  private val tests = List(
    (0, "00:00:00"),
    (5, "00:00:05"),
    (59, "00:00:59"),
    (60, "00:01:00"),
    (3599, "00:59:59"),
    (86399, "23:59:59"),
    (359999, "99:59:59")
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for $input" in {
      HumanReadableTime.makeReadable(input) shouldBe expected
    }
  }
}
