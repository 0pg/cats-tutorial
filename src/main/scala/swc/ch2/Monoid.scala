package swc.ch2

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val booleanAndMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      override def empty: Boolean = true

      override def combine(x: Boolean, y: Boolean): Boolean = x && y
    }

  implicit val intSumMonoid: Monoid[Int] =
    new Monoid[Int] {
      override def empty: Int = 0

      override def combine(x: Int, y: Int): Int = x + y
    }

  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty[A]

      override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
    }

  implicit def setIntersectionSemiGroup[A]: Semigroup[Set[A]] =
    (x: Set[A], y: Set[A]) => x intersect y
}
