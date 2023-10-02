package sierikov.codewars.kyu6;

import org.scalatest.flatspec.AnyFlatSpec

class PlayingWithPassphrasesSpec extends AnyFlatSpec {

  import PlayingWithPassphrases._

  it should "pass basic tests" in {
    check("This is a test!", 1, "hsi  etTi sats!")
    check("This is a test!", 2, "s eT ashi tist!")
    check("The quick brown fox jumps over the lazy dog.", 3, "hk oux Cpcn tipq hw 8x bml 1j9 fkh yq 9p")
  }

  private def check(s: String, n: Int, expect: String): Unit =
    assertResult(playPass(s, n), s"playPass($s, $n)") {
      expect
    }

}
