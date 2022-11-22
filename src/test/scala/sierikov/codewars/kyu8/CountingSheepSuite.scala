package sierikov.codewars.kyu8

import org.scalatest.funsuite.AnyFunSuite

class CountingSheepSuite extends AnyFunSuite {

  val basicTestCases: Seq[(Array[Boolean], Int)] = List(
    (Array(), 0),
    (Array(true), 1),
    (Array(false, true, true, false), 2)
  )

  def runTest(cases: Seq[(Array[Boolean], Int)]): Unit = cases.foreach {
    case (a, result) =>
      assertResult(result, s"Input array = ${a.mkString("Array(", ", ", ")")} ")(CountingSheep.countSheep(a))
  }

  test("basic")(runTest(basicTestCases))
}
