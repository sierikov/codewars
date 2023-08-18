package sierikov.codewars.kyu6

object WhoLikesIt {
  def likes(names: Array[String]): String = names.length match
    case 0 => "no one likes this"
    case 1 => s"${names.head} likes this"
    case 2 => s"${names.head} and ${names.last} like this"
    case 3 => s"${names.head}, ${names(1)} and ${names(2)} like this"
    case _ => s"${names.head}, ${names(1)} and ${names.length - 2} others like this"
}
