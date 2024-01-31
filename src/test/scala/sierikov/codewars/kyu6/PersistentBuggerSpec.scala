package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class PersistentBuggerSpec extends AnyFlatSpec {

  private val tests = List(
    (39, 3),
    (4, 0),
    (25, 2),
    (999, 4)
  )

  tests.foreach { case (input, expected) =>
    it should s"return $expected for input $input" in {
      PersistentBugger.persistence(input) shouldBe expected
    }
  }

}
