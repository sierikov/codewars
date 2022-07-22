package sierikov.codewars.kyu8

object Vaporcode {

  def encode(s: String): String =
    s.replaceAll(" ", "")
      .toUpperCase()
      .split("")
      .mkString("  ")
}
