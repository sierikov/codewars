package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import sierikov.codewars.kyu5.CodingWithSquaredStrings.*

class CodingWithSquaredStringsTest extends AnyFlatSpec {

  val data = "What do you remember? When I looked at his streaky glasses, I wanted " +
    "to leave him. And before that? He stole those cherries for me at midnight. We were walking " +
    "in the rain and I loved him. And before that? I saw him coming " +
    "toward me that time at the picnic, edgy, foreign."

  val dataEncoded =
    "\u000bctg?.nadr d gdbW\n\u000b,i    lnis tl eh\n\u000b mtIAakietboaara\n\u000beeo nnigsoe st?t\n\u000bd wsddnh lfls   \n\u000bgaaa  gtfeoeehWd\n" +
      "\u000bytrwbI .o rasiho\n\u000b, d e i rtev,se \n\u000b t hflnW h e  ny\n\u000bfhmioo emot Is o\n\u000boeemrvt eshh tIu\n\u000br   eehw eaiwr  \n" +
      "\u000beptc deea tmaelr\n\u000biihot  rtc?.naoe\n\u000bgcamhhre h  tkom\n\u000bnntiaia meHAeyke\n\u000b.i ntmiwirend em"

  it should "pass basic tests code" in {
    testing(code(data), dataEncoded)

  }
  it should "pass basic tests decode" in {
    testing(decode(dataEncoded), data)
  }

  private def testing(actual: String, expect: String): Unit = {
    println("Actual: " + actual)
    println("\nExpect: " + expect)
    println("-")
    assertResult(expect) {
      actual
    }
  }

}
