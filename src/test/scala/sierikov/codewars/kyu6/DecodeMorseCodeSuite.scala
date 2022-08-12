package sierikov.codewars.kyu6

import org.scalatest.funsuite.AnyFunSuite

class DecodeMorseCodeSuite extends AnyFunSuite {

  def d(msg: String): String = DecodeMorseCode.decode(msg)

  test("example from the description") {
    assertResult("HEY JUDE")(d(".... . -.--   .--- ..- -.. ."))
  }

  test("letters") {
    assertResult("A")(d(".-"))
    assertResult("E")(d("."))
    assertResult("I")(d(".."))
    assertResult("E E")(d(".   ."))
  }

  test("sentences") {
    assertResult("SOS! THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.")(
      d(
        "     ...---... -.-.--   - .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-     "
      )
    )
    assertResult("-=5( Y_SB T013NQ7Y Q.5A V6KBSH +_KDP22 S; JS'O45 :DKQS?X6 )&.5'Z4")(
      d(
        "-....- -...- ..... -.--.   -.-- ..--.- ... -...   - ----- .---- ...-- -. --.- --... -.--   --.- .-.-.- ..... .-   ...- -.... -.- -... ... ....   .-.-. ..--.- -.- -.. .--. ..--- ..---   ... -.-.-.   .--- ... .----. --- ....- .....   ---... -.. -.- --.- ... ..--.. -..- -....   -.--.- .-... .-.-.- ..... .----. --.. ....-"
      )
    )
    assertResult("Q@X!U YC3EQK! )8/'3SSXF '")(
      d("--.- .--.-. -..- -.-.-- ..-   -.-- -.-. ...-- . --.- -.- -.-.--   -.--.- ---.. -..-. .----. ...-- ... ... -..- ..-.   .----.")
    )
  }

}
