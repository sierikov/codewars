package sierikov.codewars.kyu7

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

class FriendOrFoeSpec extends AnyFlatSpec {

  private val tests = List(
    (Seq("Ryan", "Kieran", "Mark"), Seq("Ryan", "Mark")),
    (Seq("Ryan", "Jimmy", "123", "4", "Cool Man"), Seq("Ryan")),
    (Seq("Jimm", "Cari", "aret", "truehdnviegkwgvke", "sixtyiscooooool"), Seq("Jimm", "Cari", "aret")),
    (Seq("Love", "Your", "Face", "1"), Seq("Love", "Your", "Face")),
    (Seq("Hell", "Is", "a", "badd", "word"), Seq("Hell", "badd", "word")),
    (Seq("Issa", "Issac", "Issacs", "ISISS"), Seq("Issa")),
    (Seq("Robot", "Your", "MOMOMOMO"), Seq("Your")),
    (Seq("Your", "BUTT"), Seq("Your", "BUTT")),
    (Seq("Hello", "I", "AM", "Sanjay", "Gupt"), Seq("Gupt")),
    (Seq("This", "IS", "enough", "TEst", "CaSe"), Seq("This", "TEst", "CaSe")),
    (Seq(), Seq())
  )

  tests.foreach { case (input, expected) =>
    val estr = expected.take(5).map(_.headOption.getOrElse("-"))
    val istr = input.take(5).map(_.headOption.getOrElse("-"))
    it should s"return $estr with input $istr" in {
      FriendOrFoe.friend(input) shouldBe expected
    }
  }
}
