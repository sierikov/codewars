package sierikov.codewars.kyu1

object ScottEncoding {
  trait STuple[+A, +B] {
    def apply[C]: ((A, B) => C) => C
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

  def toTuple[A, B](tuple: STuple[A, B]): (A, B) =
    tuple[(A, B)]((a, b) => (a, b))

  def fromTuple[A, B](tuple: (A, B)): STuple[A, B] = new STuple[A, B] {
    def apply[C]: ((A, B) => C) => C = tuple match {
      case (a, b) => f => f(a, b)
    }
  }

  def fst[A, B](tuple: STuple[A, B]): A = tuple[A]((a, _) => a)

  def snd[B](tuple: STuple[_, B]): B = tuple[B]((_, b) => b)

  def swap[A, B](tuple: STuple[A, B]): STuple[B, A] = {
    val (a, b) = toTuple(tuple)
    fromTuple((b, a))
  }

  def curry[A, B, C](f: STuple[A, B] => C): A => B => C =
    a => b => f(fromTuple((a, b)))

  def uncurry[A, B, C](f: A => B => C): STuple[A, B] => C =
    tuple => tuple[C](Function.uncurried(f))

  def toOption[A](option: SOption[A]): Option[A] =
    option.apply(Option.empty[A], Some(_))

  def fromOption[A](option: Option[A]): SOption[A] = new SOption[A] {
    def apply[B] = (ifEmpty, f) => option.fold(ifEmpty)(f)
  }

  def isSome(option: SOption[_]): Boolean =
    option.apply(false, _ => true)

  def isNone(option: SOption[_]): Boolean =
    option.apply(true, _ => false)

  def catOptions[A](list: SList[SOption[A]]): SList[A] = {
    def dropOption = (head: SOption[A], tail: SList[SOption[A]]) =>
      if (isSome(head))
        cons(toOption(head).get, catOptions(tail))
      else
        catOptions(tail)

    list.apply(nil, dropOption)
  }

  def toEither[A, B](either: SEither[A, B]): Either[A, B] =
    either.apply(Left.apply, Right.apply)

  def fromEither[A, B](either: Either[A, B]): SEither[A, B] = new SEither[A, B] {
    def apply[C] = (left, right) => either.fold(left, right)
  }

  def isLeft(either: SEither[_, _]): Boolean =
    either.apply(_ => true, _ => false)

  def isRight(either: SEither[_, _]): Boolean =
    either.apply(_ => false, _ => true)

  def nil[A]: SList[A] = new SList[A] {
    def apply[B] = (b, _) => b
  }

  def toList[A](list: SList[A]): List[A] =
    list.apply(List.empty[A], (head, tail) => head :: toList(tail))

  def fromList[A](list: List[A]): SList[A] = list match {
    case Nil          => nil[A]
    case head :: tail => cons(head, fromList(tail))
  }

  def cons[A](head: A, list: SList[A]): SList[A] = new SList[A] {
    def apply[B] = (_, f) => f(head, list)
  }

  def concat[A](left: SList[A], right: SList[A]): SList[A] =
    left.apply(right, (leftHead, rightHead) => cons(leftHead, concat(rightHead, right)))

  def empty(list: SList[_]): Boolean =
    list.apply(true, (_, _) => false)

  def length(list: SList[_]): Int =
    list.apply(0, (_, tail) => 1 + length(tail))

  def map[A, B](f: A => B, list: SList[A]): SList[B] =
    list.apply(nil, (head, tail) => cons(f(head), map(f, tail)))

  def zip[A, B](listA: SList[A], listB: SList[B]): SList[STuple[A, B]] =
    listA.apply(nil,
                (headA, tailA) => listB.apply(nil, (headB, tailB) => cons(fromTuple((headA, headB)), zip(tailA, tailB)))
    )

  def foldLeft[A, B](f: (B, A) => B, z: B, list: SList[A]): B =
    list.apply(z, (head, tail) => foldLeft(f, f(z, head), tail))

  def foldRight[A, B](f: (A, B) => B, z: B, list: SList[A]): B =
    list[B](z, (head, tail) => f(head, foldRight(f, z, tail)))

  def take[A](n: Int, list: SList[A]): SList[A] = n match {
    case 0 => nil[A]
    case _ => list.apply(nil[A], (head, tail) => cons(head, take(n - 1, tail)))
  }

  def partition[A, B](list: SList[SEither[A, B]]): STuple[SList[A], SList[B]] =
    list.apply(
      fromTuple((nil, nil)),
      (head, tail) => {
        val (lefts, rights) = toTuple(partition(tail))
        fromTuple(
          head.apply(
            left => (cons(left, lefts), rights),
            right => (lefts, cons(right, rights))
          )
        )
      }
    )
}
