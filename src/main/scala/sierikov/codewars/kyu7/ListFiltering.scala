package sierikov.codewars.kyu7

object ListFiltering {
  def filterList(list: List[Any]): List[Int] =
    list
      .filter(_.isInstanceOf[Int])
      .map(_.asInstanceOf[Int])
}
