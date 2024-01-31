package sierikov.codewars.kyu6

object UniqueInOrder {
  def uniqueInOrder[T](xs: Iterable[T]): Seq[T] =
    xs.foldLeft(List.empty[T]) {
      case (acc, elem) if acc.isEmpty || acc.last != elem => acc :+ elem
      case (acc, _)                                       => acc
    }
}
