package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec

class NumberTrailingZerosFactTest extends AnyFlatSpec{
  it should "work with example tests" in {
    assert(NumberTrailingZerosFact.zeros(0) == 0)
    assert(NumberTrailingZerosFact.zeros(6) == 1)
    assert(NumberTrailingZerosFact.zeros(14) == 2)
  }

  it should "work with rec" in {
    assert(NumberTrailingZerosFact.zerosRec(0) == 0)
    assert(NumberTrailingZerosFact.zerosRec(6) == 1)
    assert(NumberTrailingZerosFact.zerosRec(14) == 2)
  }
}
