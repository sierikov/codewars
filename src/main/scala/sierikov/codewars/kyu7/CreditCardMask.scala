package sierikov.codewars.kyu7

object CreditCardMask {
  def maskify(cc: String): String = {
    val unmasked = 4
    if (cc.length <= unmasked) cc
    else "#" * (cc.length - unmasked) + cc.takeRight(unmasked)
  }
}
