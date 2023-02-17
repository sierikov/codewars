package sierikov.codewars.kyu7

import org.scalatest.funsuite.AnyFunSuite

class InterlockingBinaryPairsSuite extends AnyFunSuite {

  type TestCase = (Long, Long, Boolean)

  val basicTestCases: Seq[TestCase] = List(
    (9L, 4L, true),
    (3L, 6L, false),
    (2L, 5L, true),
    (7L, 1L, false),
    (0L, 8L, true)
  )

  val extendedTestCases: Seq[TestCase] = List(
    (1140L, 4367L, false),
    (493125046404L, 24584L, true),
    (102400L, 35837308854400L, true),
    (771L, 63156093928607753L, false),
    (613253914688L, 438L, true),
    (108225895783146480L, 423445227166739L, false),
    (470996387497838L, 100749658945681L, false),
    (6610039577326596L, 4622375373819L, true),
    (1097803417869039501L, 2659158371298265758L, false),
    (7904196764200455158L, 6609211195221931760L, false)
  )

  def runTest(cases: Seq[TestCase]): Unit = basicTestCases.foreach { case (a, b, result) =>
    assertResult(result, s"Inputs:  a = $a b = $b")(InterlockingBinaryPairs.interlockable(a, b))
  }

  test("basic") { runTest(basicTestCases) }
  test("extended") { runTest(extendedTestCases) }

}
