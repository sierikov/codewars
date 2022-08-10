package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class HelpYourGrannyTest extends AnyFlatSpec {

  type Friends = List[String]
  type Towns = List[(String, String)]
  type Distances = Map[String, Double]

  val testData: Seq[(Friends, Towns, Distances, Int)] = List(
    (
      List("A1", "A2", "A3", "A4", "A5"),
      List(("A1", "X1"), ("A2", "X2"), ("A3", "X3"), ("A4", "X4")),
      Map("X1" -> 100.0, "X2" -> 200.0, "X3" -> 250.0, "X4" -> 300.0),
      889
    ),
    (
      List("A1", "A2", "A3", "A4", "A5"),
      List(("A1", "X1"), ("A2", "X2"), ("A3", "X3"), ("A4", "X4"), ("A5", "X5")),
      Map("X1" -> 100.0, "X2" -> 200.0, "X3" -> 250.0, "X4" -> 300.0, "X5" -> 320.0),
      1020
    ),
    (
      List("B1", "B2"),
      List(("B1", "Y1"), ("B2", "Y2"), ("B3", "Y3"), ("B4", "Y4"), ("B5", "Y5")),
      Map("Y1" -> 50.0, "Y2" -> 70.0, "Y5" -> 150.0, "Y4" -> 110.0, "Y3" -> 90.0),
      168
    ),
    (
      List("B1", "B2", "B3"),
      List(("B1", "Y1"), ("B2", "Y2"), ("B3", "Y3"), ("B4", "Y4"), ("B5", "Y5")),
      Map("Y1" -> 60.0, "Y2" -> 80.0, "Y5" -> 150.0, "Y4" -> 110.0, "Y3" -> 100.0),
      272
    )
  )
  it should "pass basic tests" in {
    testData.map {
      case (friends, towns, distances, result) => HelpYourGranny.tour(friends, towns, distances) shouldEqual result
    }
  }
}
