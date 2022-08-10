package sierikov.codewars.kyu3

import scala.util.matching.Regex

object TexasHoldHand {

  type Result = (String, List[String])

  sealed trait Suit
  case object Diamonds extends Suit // ♦
  case object Hearts extends Suit // ♥
  case object Spades extends Suit // ♠
  case object Clubs extends Suit // ♣

  object Suit {

    def apply(ch: Char): Suit = ch match {
      case '♦' => Diamonds
      case '♥' => Hearts
      case '♠' => Spades
      case '♣' => Clubs
    }
  }

  case class Card(mark: String, rank: Int, suit: Suit) {

    override def equals(that: Any): Boolean = that match {
      case that: Card => this.hashCode == that.hashCode
      case _ => false
    }

    override def hashCode(): Int = this.rank + this.mark.hashCode
  }

  object Card {
    val cardR: Regex = """(\S{1,2})(\S)""".r
    val numberR: Regex = """\d{1,2}""".r

    def calcRank(mark: String): Int = mark match {
      case "A" => 14
      case "K" => 13
      case "Q" => 12
      case "J" => 11
      case numberR(_*) => mark.toInt
      case _ => -1
    }

    def apply(s: String): Card = s match {
      case cardR(mark, s) => Card(mark, calcRank(mark), Suit(s.head))
    }
  }

  def hand(hole: List[String], community: List[String]): Result =
    findCombination((hole ++ community).map(Card.apply).sortByRank)

  object Detector {

    def checkPair(cards: List[Card]): Option[Result] = {
      val pair = cards.groupRankAmount.removeGroupsLess(2)

      if (pair.isEmpty) return None

      val pairMark = pair.getCards.sortByRank.firstMark
      val others = cards.filterNot(_.mark == pairMark).sortByRank.take(3).marks

      Some("pair", List(pairMark) ++ others)
    }

    def checkTwoPair(cards: List[Card]): Option[Result] = {
      val pairCards = cards.groupRankAmount.removeGroupsLess(2)

      if (pairCards.isEmpty || pairCards.size < 2) return None

      val twoPairs = pairCards.getCards.sortByRank.take(2).marks
      val others = cards.filterNot(card => twoPairs.contains(card.mark)).sortByRank.firstMark

      Some("two pair", twoPairs ++ List(others))
    }

    def checkFourOfKind(cards: List[Card]): Option[Result] = {
      val result = cards.groupRankAmount
      val four = result.removeGroupsLess(4).getCards

      if (four.isEmpty) return None

      val fourMark = four.firstMark
      val otherMark = cards.filterNot(_.mark == fourMark).sortByRank.firstMark

      Some(("four-of-a-kind", List(fourMark, otherMark)))
    }

    def checkThreeOfKind(cards: List[Card]): Option[Result] = {
      val three = cards.groupRankAmount.removeGroupsLess(3).getCards

      if (three.isEmpty) return None

      val threeMark = three.firstMark
      val otherMarks = cards.filterNot(_.mark == threeMark).sortByRank.take(2).marks

      Some("three-of-a-kind", List(threeMark) ++ otherMarks)

    }

    def checkFullHouse(cards: List[Card]): Option[Result] = {
      val result = cards.groupRankAmount

      if (result.size < 3) return None

      val three = result.removeGroupsLess(3).sortByRank

      if (three.isEmpty) return None

      val threeMark = three.getCards.firstMark
      val other = result
        .filterNot(threeMark == _._1.mark)
        .sortByRank
        .removeGroupsLess(2)

      if (other.isEmpty) return None

      Some(("full house", List(threeMark, other.getCards.firstMark)))
    }

    def checkFlush(cards: List[Card]): Option[Result] = {
      val result = cards.groupSuite.filter { case (_, cards) => cards.size >= 5 }.values

      if (result.isEmpty) return None

      Some("flush", result.head.take(5).marks)
    }

    def checkStraight(cards: List[Card]): Option[Result] = isStraight(cards).map(cards => ("straight", cards.marks))

    def checkStraightFlush(cards: List[Card]): Option[Result] = {
      val result = cards.groupSuite
        .map { case (suit, cards) => (suit, isStraight(cards)) }
        .filter { case (_, cards) => cards.isDefined }
        .values

      if (result.isEmpty) return None

      Some(("straight-flush", result.head.get.marks))
    }

    def isStraight(cards: List[Card]): Option[List[Card]] = {
      def check(control: Int, select: List[Int]): Boolean =
        select.zipWithIndex
          .map { case (element, index) => element + index }
          .count(_ == control) == select.size

      val sorted = cards.sortByRank.distinct
      val ranks = sorted.map(_.rank)

      if (ranks.length >= 5 && check(ranks.head, ranks.slice(0, 5))) Some(sorted.slice(0, 5))
      else if (ranks.length >= 6 && check(ranks(1), ranks.slice(1, 6))) Some(sorted.slice(1, 6))
      else if (ranks.length >= 7 && check(ranks(2), ranks.slice(2, 7))) Some(sorted.slice(2, 7))
      else None
    }

  }

  def findCombination(cards: List[Card]): (String, List[String]) = {
    import Detector._

    checkStraightFlush(cards)
      .orElse(checkFourOfKind(cards))
      .orElse(checkFullHouse(cards))
      .orElse(checkFlush(cards))
      .orElse(checkStraight(cards))
      .orElse(checkThreeOfKind(cards))
      .orElse(checkTwoPair(cards))
      .orElse(checkPair(cards))
      .getOrElse(("nothing", cards.sortByRank.marks.take(5)))

  }

  implicit class PokerExtension(cards: List[Card]) {
    def marks: List[String] = cards.map(_.mark)
    def firstMark: String = cards.head.mark
    def groupSuite: Map[Suit, List[Card]] = cards.groupBy(_.suit)
    def groupRank: Map[Int, List[Card]] = cards.groupBy(_.rank)
    def groupRankAmount: List[(Card, Int)] = cards.groupRank.map { case (_, cards) => (cards.head, cards.size) }.toList
    def sortByRank: List[Card] = cards.sortWith(_.rank > _.rank)
  }

  implicit class PokerExtensionMap(cards: List[(Card, Int)]) {
    def getCards: List[Card] = cards.map { case (card, _) => card }
    def removeGroupsLess(size: Int): List[(Card, Int)] = cards.filter { case (_, amount) => amount >= size }
    def sortByRank: List[(Card, Int)] = cards.sortWith(_._1.rank >= _._1.rank)
  }
}
