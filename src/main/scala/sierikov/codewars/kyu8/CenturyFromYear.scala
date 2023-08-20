package sierikov.codewars.kyu8

object CenturyFromYear {

  def centuryFromYear(year: Int): Int = {
    val century = year / 100
    if year % 100 == 0 then century else century + 1
  }

}
