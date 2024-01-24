package sierikov.codewars.kyu6;

import org.scalatest.flatspec.AnyFlatSpec

class PlayingWithPassphrasesSpec extends AnyFlatSpec {

  import PlayingWithPassphrases._

  it should "pass basic tests" in {
    check("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2, "4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO")
  }

  it should "pass additional tests" in {
    check("HELLO WORLD", 1, "EmSpX PmMfI")
    check("1234567890", 3, "9012345678")
    check("THIS IS A TEST", 4, "xWiX E Wm wMlX")
    check("PASSWORD123", 5, "678iWtBxXfU")
    check("ABCDEF", 6, "lKjIhG")
  }

  private def check(s: String, n: Int, expect: String): Unit =
    assertResult(expect, s"playPass($s, $n)") {
      playPass(s, n)
    }

}
