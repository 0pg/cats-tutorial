package swc.ch1

import java.util.Date

object PrintableInstances {

  import Printable._

  implicit val stringPrintable: Printable[String] =
    (value: String) => value
  implicit val intPrintable: Printable[Int] =
    (value: Int) => value.toString
  implicit val catPrintable: Printable[Cat] = {
    (value: Cat) => {
      val name = format(value.name)
      val age = format(value.age)
      val color = format(value.color)
      s"$name is a $age year-old $color cat."
    }
  }
  implicit val datePrintable: Printable[Date] = {
    (value: Date) => value.toString
  }
}
