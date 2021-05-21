package hyperconnect

object NumbersToText {
  def numbersToLetters(s: String): String = {
    def mkLetterFromAsciiNumber(number: Int): String = {
      val asciiOffset = 64
      (number + asciiOffset).toChar.toString
    }
    def mkStringFromContainsPlusSign(stringWithPlus: String) =
      stringWithPlus.split("\\+").map(chunk => mkLetterFromAsciiNumber(chunk.toInt)).mkString(" ")

    s.split(" ").map(chunk => {
      if (chunk.contains("+")) mkStringFromContainsPlusSign(chunk)
      else mkLetterFromAsciiNumber(chunk.toInt)
    }).mkString("")
  }

  def main(args: Array[String]) = {
    println(numbersToLetters("20 5 19 20+4 15 13 5"))
    println(numbersToLetters("1+2+3+4 1+2 1"))
  }
}