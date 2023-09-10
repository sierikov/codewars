package sierikov.codewars.kyu7

object PrinterErrors {
  def printerError(s: String): String = {
    val errors = s.count(c => c > 'm')
    s"$errors/${s.length}"
  }
}
