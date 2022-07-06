package sierikov.codewars.kyu5

import scala.collection.mutable

object RgbToHexConversion {

  def toHex(bytes: Seq[Byte]): String = {
    val sb = new mutable.StringBuilder
    for (b <- bytes) {
      sb.append(String.format("%02x", Byte.box(b)))
    }
    sb.toString
  }

  def normalize(i: Int): Int =
    if (i > 255) 255
    else if (i < 0) 0
    else i

  def toRgb(r: Int, g: Int, b: Int): String = toHex(Seq(r, g, b).map(normalize).map(_.toByte)).toUpperCase
}
