package sierikov.codewars.kyu7

import scala.annotation.tailrec

object ValidParentheses {

  def validParentheses(str: String): Boolean = {
    if (str.headOption.fold(false)(_ == ')')) false
    else
      loop(str).isEmpty
  }

  @tailrec
  def loop(str: String, stack: List[String] = List.empty): List[String] =
    if str.isEmpty then stack
    else
      str.head match
        case '('                  => loop(str.tail, stack :+ "(")
        case ')' if stack.isEmpty => stack :+ "invalid closing"
        case ')'                  => loop(str.tail, stack.init)
}
