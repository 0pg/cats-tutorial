package cws.ch2

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  def apply[A](implicit semigroup: Semigroup[A]): Semigroup[A] = semigroup

  implicit def setIntersectionSemiGroup[A]: Semigroup[Set[A]] =
    (x: Set[A], y: Set[A]) => x intersect y
}