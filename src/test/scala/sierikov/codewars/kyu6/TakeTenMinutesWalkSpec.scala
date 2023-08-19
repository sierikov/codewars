package sierikov.codewars.kyu6

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldEqual

class TakeTenMinutesWalkSpec extends AnyFlatSpec {
  import TakeTenMinutesWalk._

  private val validWalks = Seq(
    Seq('n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's')
  )

  private val invalidWalks = Seq(
    Seq('w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'),
    Seq('w'),
    Seq('n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's')
  )

  validWalks.foreach { valid =>
    s"isValidWalk($valid)" should "return true" in {
      assert(isValidWalk(valid))
    }
  }

  invalidWalks.foreach { invalid =>
    s"isValidWalk($invalid)" should "return false" in {
      assert(!isValidWalk(invalid))
    }
  }
}
