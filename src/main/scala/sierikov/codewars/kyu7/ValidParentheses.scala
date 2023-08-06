package sierikov.codewars.kyu7

import scala.annotation.tailrec

object ValidParentheses {

  @tailrec
  def validParentheses(str: String, depth: Int = 0): Boolean =
    if depth < 0 || (str.isEmpty && depth > 0) then false
    else if str.isEmpty then true
    else if str.head == '(' then validParentheses(str.tail, depth + 1)
    else validParentheses(str.tail, depth - 1)
}
