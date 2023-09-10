package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class ListFilteringSpec extends AnyFlatSpec {

  import ListFiltering.filterList

  private val tests = List(
    (List(1, 2, "a", "b"), List(1, 2)),
    (List(1, "a", "b", 0, 15), List(1, 0, 15)),
    (List(1, 2, "aasf", "1", "123", 123), List(1, 2, 123)),
    (List("a", "b", "1"), Nil)
  )

  it should "filter all strings from list" in {
    tests.foreach { case (input, expected) =>
      filterList(input) shouldBe expected
    }
  }

}
