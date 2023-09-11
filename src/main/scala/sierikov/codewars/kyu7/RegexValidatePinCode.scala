package sierikov.codewars.kyu7

object RegexValidatePinCode {

  def validatePin(pin: String): Boolean = pin.matches("\\d{4}|\\d{6}")

}
