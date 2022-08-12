package sierikov.codewars.kyu3

import java.math.BigInteger

object MillionthFibonacci {

  def fib(n: Int): BigInt = {
    val result = fibonacci(Math.abs(n))

    // negative numbers support
    if (n < 0 && n % 2 == 0) result.bigInteger.negate
    else result
  }

  // mutable fast double algorithm
  def fibonacci(n: Int): BigInt = {
    var a: BigInteger = BigInteger.ZERO
    var b: BigInteger = BigInteger.ONE

    var m = 0
    var bit = Integer.highestOneBit(n)
    while (bit != 0) {
      // Double it
      val d = multiply(a, b.shiftLeft(1).subtract(a))
      val e = multiply(a, a).add(multiply(b, b))
      a = d
      b = e
      m *= 2
      // Advance by one conditionally
      if ((n & bit) != 0) {
        val c = a.add(b)
        a = b
        b = c
        m += 1
      }

      bit >>>= 1
    }
    a
  }

  def multiply(x: BigInteger, y: BigInteger): BigInteger = x.multiply(y)
}
