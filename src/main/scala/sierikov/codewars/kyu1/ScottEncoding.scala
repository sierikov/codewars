package sierikov.codewars.kyu1

object ScottEncoding {
  trait STuple[+A, +B] {
    def apply[C]: ((A, B) => C) => C
    def _1: A = apply((a, _) => a)
    def _2: B = apply((_, b) => b)
    def swap: STuple[B, A] = apply((a, b) => STupleImpl(b, a))
  }

  trait SOption[+A] {
    def apply[B]: (=> B, A => B) => B
  }

  trait SEither[+A, +B] {
    def apply[C]: (A => C, B => C) => C
  }

  trait SList[+A] {
    def apply[B]: (=> B, (A, SList[A]) => B) => B
  }

  case class STupleImpl[A, B](a: A, b: B) extends STuple[A, B] {
    override def apply[C]: ((A, B) => C) => C = f => f(a, b)
  }

  def toTuple[A, B](tuple: STuple[A, B]): (A, B) = (tuple._1, tuple._2)

  def fromTuple[A, B](tuple: (A, B)): STuple[A, B] = STupleImpl(tuple._1, tuple._2)

  def fst[A, B](tuple: STuple[A, B]): A = tuple._1

  def snd[B](tuple: STuple[_, B]): B = tuple._2

  def swap[A, B](tuple: STuple[A, B]): STuple[B, A] = tuple.swap

  def curry[A, B, C](f: STuple[A, B] => C): A => B => C = x => y => f(fromTuple(x, y))

  def uncurry[A, B, C](f: A => B => C): STuple[A, B] => C = tuple => f(fst(tuple))(snd(tuple))

  def toOption[A](option: SOption[A]): Option[A] = option.apply(None, Some(_))

  def fromOption[A](option: Option[A]): SOption[A] = new SOption[A] {
    override def apply[B]: (=> B, A => B) => B = (b, a) => option.fold(b)(a)
  }

  def isSome(option: SOption[_]): Boolean = option.apply(true, _ => false)

  def isNone(option: SOption[_]): Boolean = option.apply(false, _ => true)

  def catOptions[A](list: SList[SOption[A]]): SList[A] = ???

  def toEither[A, B](either: SEither[A, B]): Either[A, B] = ???

  def fromEither[A, B](either: Either[A, B]): SEither[A, B] = ???

  def isLeft[A](either: SEither[A, _]): Boolean = ???

  def isRight[A](either: SEither[A, _]): Boolean = ???

  def nil[A]: SList[A] = ???

  def toList[A](list: SList[A]): List[A] = ???

  def fromList[A](list: List[A]): SList[A] = ???

  def cons[A](head: A, list: SList[A]): SList[A] = ???

  def concat[A](left: SList[A], right: SList[A]): SList[A] = ???

  def empty(list: SList[_]): Boolean = ???

  def length(list: SList[_]): Int = ???

  def map[A, B](f: (A => B), list: SList[A]): SList[B] = ???

  def zip[A, B](listA: SList[A], listB: SList[B]): SList[STuple[A, B]] = ???

  def foldLeft[A, B](f: ((B, A) => B), z: B, list: SList[A]): B = ???

  def foldRight[A, B](f: ((A, B) => B), z: B, list: SList[A]): B = ???

  def take[A](n: Int, list: SList[A]): SList[A] = ???

  def partition[A, B](list: SList[SEither[A, B]]): STuple[SList[A], SList[B]] = ???
}
