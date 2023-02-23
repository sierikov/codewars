package sierikov.codewars.kyu5

import sierikov.codewars.kyu5.LunarDrill.Drill.parse

import scala.annotation.tailrec
import scala.util.matching.Regex

object LunarDrill {

  /**
    * Calculates the needed amount of tact (weeks) to excavate given canvas.
    *
    * @param canvas String with rows separated with `\n`
    * @return amount of tact
    */
  def drill(canvas: String): Int =
    val i = canvas.split("\n").toList.map(split).map(Drill.parse)
    tact(i)

  /**
    * Simulates the state for each tact
    * @param l list of [[Drill]]
    * @param cycle amount of tact that already passed
    * @return amount of tact needed to excavate all rocks
    */
  @tailrec
  private def tact(l: List[Drill], cycle: Int = 0): Int = {
    val isDone = l.forall(_.isDone)
    if (isDone) return cycle

    val slowestDrillCost = l.map(_.costForNextTile).max
    val updatedDrills = l.map(_.excavateOneTile)

    tact(updatedDrills, cycle + slowestDrillCost)
  }

  /**
    * Represents a path of rocks
    * @param tiles list of [[Tile]]
    */
  case class Path(tiles: List[Tile]) {

    /**
      * Drops first tile from the path if it is not empty
      * @return new [[Path]] without first tile
      */
    def dropFirst: Path =
      if (tiles.isEmpty) this
      else new Path(tiles.tail)

    /**
      * Checks if path has no rocks to excavate
      * @return true if path is empty
      */
    def isClear: Boolean = tiles.forall(_.value == 0)

    /**
      * Returns first tile from the path in a safe way
      * @return [[Tile]] or [[Tile.SolidGround]] if path is empty
      */
    def head: Tile = tiles.headOption match
      case None    => Tile.SolidGround
      case Some(t) => t
  }

  object Path {
    def apply(s: String) = new Path(s.map(Tile.apply).toList)
    def empty = new Path(List.empty[Tile])
  }

  trait Tile(val value: Int)
  object Tile {
    def apply(s: Char): Tile = s match {
      case '.' => SolidGround
      case '*' => SoftRock
      case 'x' => MediumRock
      case 'X' => HardRock
      case '@' => VeryHardRock
    }

    def apply(i: Int): Tile = i match {
      case 0 => SolidGround
      case 1 => SoftRock
      case 2 => MediumRock
      case 3 => HardRock
      case 4 => VeryHardRock
    }

    case object SolidGround extends Tile(0)
    case object SoftRock extends Tile(1)
    case object MediumRock extends Tile(2)
    case object HardRock extends Tile(3)
    case object VeryHardRock extends Tile(4)
  }

  case class Drill(power: Int, speed: Int, path: Path) {
    private def attack: Int = power * speed
    def costForNextTile: Int = {
      val tactNeeded = (path.head.value.toDouble / attack.toDouble).ceil.toInt
      1.max(tactNeeded)
    }
    def excavateOneTile: Drill = this.copy(path = path.dropFirst)
    def isDone: Boolean = path.isClear
  }

  object Drill {

    /**
      * Regex to parse drill and path from string
      * Example: `--->` will be parsed as `--` and `->`
      */
    val drillr: Regex = """´`:(-+|=+)(>+)""".r

    /**
      * Parses string into [[Drill]] and [[Path]]
      * @param s string for drill
      * @param p string of path of rocks
      * @return [[Drill]]
      */
    def parse(s: String, p: String): Drill = s match {
      case drillr(arm, drill) => {
        val power = arm.head match {
          case '-' => 1
          case '=' => 2
        }
        val speed = drill.length
        new Drill(power, speed, Path(p))
      }
    }

  }

  /**
    * Splits string into two parts: drill and path
    * See [[Drill.drillr]]
    *
    * @param s string to split
    * @return tuple of drill and path as [[String]]
    */
  def split(s: String): (String, String) = s.splitAt(s.lastIndexOf('>') + 1)
}
