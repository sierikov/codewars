package sierikov.codewars.kyu3

import org.scalatest.funsuite.AnyFunSuite

class TexasHoldHandSuite extends AnyFunSuite {

  test("Nothing") {

    test(
      holeCards = List("6♣", "A♦"),
      communityCards = List("7♦", "Q♦", "K♣", "5♠", "8♣"),
      expected = ("nothing", List("A", "K", "Q", "8", "7"))
    )

    test(
      holeCards = List("7♥", "K♦"),
      communityCards = List("8♣", "J♠", "Q♥", "6♣", "5♥"),
      expected = ("nothing", List("K", "Q", "J", "8", "7"))
    )

    test(
      holeCards = List("K♠", "A♦"),
      communityCards = List("J♣", "Q♥", "9♥", "2♥", "3♦"),
      expected = ("nothing", List("A", "K", "Q", "J", "9"))
    )
  }

  test("Pair") {

    test(
      holeCards = List("K♠", "Q♦"),
      communityCards = List("J♣", "Q♥", "9♥", "2♥", "3♦"),
      expected = ("pair", List("Q", "K", "J", "9"))
    )

    test(
      holeCards = List("K♠", "Q♦"),
      communityCards = List("J♣", "Q♥", "9♥", "2♥", "3♦"),
      expected = ("pair", List("Q", "K", "J", "9"))
    )
  }

  test("Two pair") {

    test(
      holeCards = List("K♠", "J♦"),
      communityCards = List("J♣", "K♥", "9♥", "2♥", "3♦"),
      expected = ("two pair", List("K", "J", "9"))
    )

    test(
      holeCards = List("A♠", "2♠"),
      communityCards = List("2♥", "8♥", "A♣", "8♦", "4♠"),
      expected = ("two pair", List("A", "8", "4"))
    )

    test(
      holeCards = List("5♦", "2♣"),
      communityCards = List("2♥", "K♥", "9♠", "K♠", "9♣"),
      expected = ("two pair", List("K", "9", "5"))
    )

    test(
      holeCards = List("Q♥", "3♠"),
      communityCards = List("7♦", "3♣", "9♠", "7♥", "9♥"),
      expected = ("two pair", List("9", "7", "Q"))
    )

    test(
      holeCards = List("K♣", "2♣"),
      communityCards = List("2♦", "K♥", "A♥", "A♦", "6♣"),
      expected = ("two pair", List("A", "K", "6"))
    )
  }

  test("Three of a kind") {

    test(
      holeCards = List("4♠", "9♦"),
      communityCards = List("J♣", "Q♥", "Q♠", "2♥", "Q♦"),
      expected = ("three-of-a-kind", List("Q", "J", "9"))
    )

    test(
      holeCards = List("10♣", "10♥"),
      communityCards = List("10♦", "6♥", "3♠", "5♥", "K♦"),
      expected = ("three-of-a-kind", List("10", "K", "6"))
    )

    test(
      holeCards = List("4♣", "4♦"),
      communityCards = List("K♣", "4♠", "5♣", "6♦", "2♦"),
      expected = ("three-of-a-kind", List("4", "K", "6"))
    )

    test(
      holeCards = List("8♦", "J♥"),
      communityCards = List("Q♠", "10♠", "8♠", "2♠", "8♣"),
      expected = ("three-of-a-kind", List("8", "Q", "J"))
    )

    test(
      holeCards = List("Q♣", "9♥"),
      communityCards = List("2♥", "Q♦", "K♠", "Q♥", "J♦"),
      expected = ("three-of-a-kind", List("Q", "K", "J"))
    )

    test(
      holeCards = List("J♣", "4♣"),
      communityCards = List("4♦", "7♠", "4♥", "Q♠", "9♦"),
      expected = ("three-of-a-kind", List("4", "Q", "J"))
    )
  }

  test("Straight") {

    test(
      holeCards = List("Q♠", "2♦"),
      communityCards = List("J♣", "10♥", "9♥", "K♥", "3♦"),
      expected = ("straight", List("K", "Q", "J", "10", "9"))
    )

    test(
      holeCards = List("A♠", "10♠"),
      communityCards = List("9♦", "J♥", "8♦", "9♣", "7♦"),
      expected = ("straight", List("J", "10", "9", "8", "7"))
    )

    test(
      holeCards = List("3♠", "Q♠"),
      communityCards = List("J♦", "6♣", "8♦", "10♠", "9♥"),
      expected = ("straight", List("Q", "J", "10", "9", "8"))
    )

    test(
      holeCards = List("7♥", "5♥"),
      communityCards = List("9♣", "8♥", "Q♠", "K♥", "6♣"),
      expected = ("straight", List("9", "8", "7", "6", "5"))
    )

  }

  test("Flush") {
    test(
      holeCards = List("A♠", "K♦"),
      communityCards = List("J♥", "5♥", "10♥", "Q♥", "3♥"),
      expected = ("flush", List("Q", "J", "10", "5", "3"))
    )

    test(
      holeCards = List("5♠", "7♦"),
      communityCards = List("6♠", "J♠", "9♠", "10♠", "8♠"),
      expected = ("flush", List("J", "10", "9", "8", "6"))
    )

    test(
      holeCards = List("3♦", "5♦"),
      communityCards = List("2♦", "K♦", "9♦", "A♦", "4♦"),
      expected = ("flush", List("A", "K", "9", "5", "4"))
    )

    test(
      holeCards = List("J♦", "9♥"),
      communityCards = List("Q♥", "4♥", "3♥", "6♥", "5♥"),
      expected = ("flush", List("Q", "9", "6", "5", "4"))
    )

  }

  test("Full house") {

    test(
      holeCards = List("A♠", "A♦"),
      communityCards = List("K♣", "K♥", "A♥", "Q♥", "3♦"),
      expected = ("full house", List("A", "K"))
    )

    test(
      holeCards = List("A♦", "Q♥"),
      communityCards = List("K♣", "A♥", "K♦", "K♥", "A♠"),
      expected = ("full house", List("A", "K"))
    )

    test(
      holeCards = List("K♣", "10♦"),
      communityCards = List("6♣", "6♥", "10♠", "6♠", "10♥"),
      expected = ("full house", List("10", "6"))
    )

    test(
      holeCards = List("7♠", "9♠"),
      communityCards = List("9♥", "A♣", "9♦", "A♥", "7♣"),
      expected = ("full house", List("9", "A"))
    )

    test(
      holeCards = List("Q♣", "J♦"),
      communityCards = List("Q♠", "J♥", "Q♦", "K♥", "J♠"),
      expected = ("full house", List("Q", "J"))
    )

    test(
      holeCards = List("2♦", "2♠"),
      communityCards = List("K♣", "7♣", "7♥", "7♦", "2♥"),
      expected = ("full house", List("7", "2"))
    )

  }

  test("Four of a kind") {

    test(
      holeCards = List("10♣", "2♠"),
      communityCards = List("8♥", "8♦", "8♣", "8♠", "10♥"),
      expected = ("four-of-a-kind", List("8", "10"))
    )

    test(
      holeCards = List("2♠", "3♦"),
      communityCards = List("2♣", "2♥", "3♠", "3♥", "2♦"),
      expected = ("four-of-a-kind", List("2", "3"))
    )

    test(
      holeCards = List("10♥", "5♥"),
      communityCards = List("10♦", "10♣", "4♦", "10♠", "K♠"),
      expected = ("four-of-a-kind", List("10", "K"))
    )

    test(
      holeCards = List("10♣", "6♦"),
      communityCards = List("10♥", "10♠", "10♦", "J♠", "5♣"),
      expected = ("four-of-a-kind", List("10", "J"))
    )

    test(
      holeCards = List("A♦", "K♠"),
      communityCards = List("A♥", "9♥", "A♣", "A♠", "3♥"),
      expected = ("four-of-a-kind", List("A", "K"))
    )

    test(
      holeCards = List("2♠", "4♠"),
      communityCards = List("10♥", "4♥", "Q♥", "4♣", "4♦"),
      expected = ("four-of-a-kind", List("4", "Q"))
    )

    test(
      holeCards = List("10♦", "10♥"),
      communityCards = List("4♦", "10♠", "10♣", "Q♣", "5♦"),
      expected = ("four-of-a-kind", List("10", "Q"))
    )

    test(
      holeCards = List("8♠", "A♦"),
      communityCards = List("7♣", "A♠", "A♣", "6♣", "A♥"),
      expected = ("four-of-a-kind", List("A", "8"))
    )
  }

  test("Straight flush") {
    test(
      holeCards = List("8♠", "6♠"),
      communityCards = List("7♠", "5♠", "9♠", "J♠", "10♠"),
      expected = ("straight-flush", List("J", "10", "9", "8", "7"))
    )

    test(
      holeCards = List("3♠", "A♦"),
      communityCards = List("7♠", "4♠", "6♠", "8♦", "5♠"),
      expected = ("straight-flush", List("7", "6", "5", "4", "3"))
    )

    test(
      holeCards = List("K♣", "7♥"),
      communityCards = List("10♣", "J♣", "Q♣", "9♣", "J♦"),
      expected = ("straight-flush", List("K", "Q", "J", "10", "9"))
    )

    test(
      holeCards = List("2♥", "K♦"),
      communityCards = List("4♥", "3♥", "6♥", "6♦", "5♥"),
      ("straight-flush", List("6", "5", "4", "3", "2"))
    )

    test(
      holeCards = List("J♣", "6♦"),
      communityCards = List("3♦", "5♦", "4♦", "2♦", "6♠"),
      ("straight-flush", List("6", "5", "4", "3", "2"))
    )

    test(
      holeCards = List("2♥", "K♦"),
      communityCards = List("4♥", "3♥", "6♥", "6♦", "5♥"),
      ("straight-flush", List("6", "5", "4", "3", "2"))
    )

    test(
      holeCards = List("8♠", "9♦"),
      communityCards = List("8♦", "4♠", "10♦", "J♦", "7♦"),
      ("straight-flush", List("J", "10", "9", "8", "7"))
    )

  }

  private def test(holeCards: List[String], communityCards: List[String], expected: (String, List[String])): Unit =
    withClue(s"""${holeCards.mkString(" ")} -- ${communityCards.mkString(" ")}\n""") {
      assert(TexasHoldHand.hand(holeCards, communityCards) === expected)
    }
}
