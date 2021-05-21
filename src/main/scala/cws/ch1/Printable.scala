package cws.ch1

object Printable {

  trait Printable[A] {
    def format(value: A): String
  }

  def format[A](value: A)(implicit printable: Printable[A]): String = printable.format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit = println(printable.format(value))
}
