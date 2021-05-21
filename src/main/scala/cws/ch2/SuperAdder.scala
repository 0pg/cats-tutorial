package cws.ch2

trait SuperAdder[A] {
  def add(items: List[A]): A
}

object SuperAdder {
  import cats.Monoid
  import cats.syntax.semigroup._

  def apply[A](implicit adder: SuperAdder[A]): SuperAdder[A] = adder

  implicit def add[A: Monoid](items:List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)
}
