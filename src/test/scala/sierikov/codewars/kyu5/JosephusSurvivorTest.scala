package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class JosephusSurvivorTest extends AnyFlatSpec with Matchers {

  List(
    (7, 3, 4),
    (11, 19, 10),
    (40, 3, 28),
    (14, 2, 13),
    (100, 1, 100),
    (1, 300, 1),
    (2, 300, 1),
    (5, 300, 1),
    (7, 300, 7),
    (300, 300, 265)
  ).foreach {
    case (n, k, exp) =>
      s"josephusSurvivor($n, $k)" should s"return $exp" in {
        JosephusSurvivor.calc(n, k) shouldBe exp
      }
  }
}
