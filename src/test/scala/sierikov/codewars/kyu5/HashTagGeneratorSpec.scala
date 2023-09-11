package sierikov.codewars.kyu5

import org.scalatest.flatspec.AnyFlatSpec

class HashTagGeneratorSpec extends AnyFlatSpec {
  import HashTagGenerator._

  it should "work with a single word" in {
    assert(generateHashtag("Codewars") == "#Codewars")
  }

  it should "process acronyms" in {
    assert(generateHashtag("Codewars a w s") == "#CodewarsAWS")
  }

  it should "trim all leading/trailing/double whitespace" in {
    assert(generateHashtag(" Codewars ") == "#Codewars")
  }

  it should "remove unneded capitalization" in {
    assert(generateHashtag("CODEWARS iS NiCe") == "#CodewarsIsNice")
  }

  it should "pass stress tests" in {
    assert(generateHashtag("a".repeat(139)) == "#A" + "a".repeat(138))
    assert(generateHashtag("a".repeat(140)) == "")
  }
}
