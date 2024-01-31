package sierikov.codewars.kyu7

object FriendOrFoe {
  def friend(list: Seq[String]): Seq[String] =
    list.filter(_.length == 4)
}
