package sierikov.codewars.kyu6

import scala.collection.immutable.HashMap

object DecodeMorseCode {

  // order and codes are given by kata
  object MorseCodes {

    val morseCodes: Map[String, String] = HashMap(
      "---..." -> ":",
      "...-..-" -> "$",
      "...." -> "H",
      ".-." -> "R",
      ".-.-." -> "+",
      "-...." -> "6",
      ".--." -> "P",
      "-.--.-" -> ")",
      "..--.." -> "?",
      "-.-." -> "C",
      "--.-" -> "Q",
      "..-." -> "F",
      ".-..." -> "&",
      ".--" -> "W",
      "---.." -> "8",
      "..-" -> "U",
      "-." -> "N",
      "-----" -> "0",
      "-....-" -> "-",
      "." -> "E",
      "--..--" -> ",",
      "-..-" -> "X",
      ".----" -> "1",
      "..--.-" -> "_",
      "--." -> "G",
      "-.--." -> "(",
      "-..-." -> "/",
      ".----." -> "'",
      "...-" -> "V",
      "-" -> "T",
      ".--.-." -> "@",
      "---" -> "O",
      ".-" -> "A",
      "....-" -> "4",
      "-.-.-." -> ";",
      "-.." -> "D",
      ".." -> "I",
      ".-..-." -> "\"",
      "-.--" -> "Y",
      "--.." -> "Z",
      "...--" -> "3",
      "..." -> "S",
      "....." -> "5",
      "----." -> "9",
      "--" -> "M",
      ".-.-.-" -> ".",
      "..---" -> "2",
      "...---..." -> "SOS",
      "-.-" -> "K",
      ".-.." -> "L",
      ".---" -> "J",
      "-...-" -> "=",
      "-..." -> "B",
      "--..." -> "7",
      "-.-.--" -> "!"
    )
  }

  val getWords: String => List[String] = code => code.split(" {3}").toList
  val composeMessage: List[String] => String = msg => msg.mkString(" ")

  val decodeWords: List[String] => List[String] = words => words.map(getLetters andThen decodeLetters).map(_.mkString)

  val getLetters: String => List[String] = word => word.split(" ").toList
  val decodeLetters: List[String] => List[String] = letters => letters.map(MorseCodes.morseCodes.getOrElse(_, ""))

  val d: String => String = getWords andThen decodeWords andThen composeMessage

  def decode(msg: String): String = d.apply(msg).trim

}
