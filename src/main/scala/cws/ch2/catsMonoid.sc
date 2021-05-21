import cats.Monoid
import cats.instances.string._

Monoid[String].combine("Hi ", "there")
Monoid[String].empty

import cats.Semigroup

Semigroup[String].combine("Hi ", "there")

import cats.instances.int._

Monoid[Int].combine(32, 10)

import cats.instances.option._

Monoid[Option[Int]].combine(Option(1), None)

import cats.implicits._
import cats.syntax.semigroup._

val stringResult = "Hi " |+| "there" |+| Monoid[String].empty
val intResult = 1 |+| 2 |+| 3 |+| Monoid[Int].empty

import cws.ch2.SuperAdder._
add(List(1, 2, 3))
add(List(Option(1), Option(2), None, Some(3)))

case class Order(totalCost: Double, quantity: Double)

implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
  override def empty: Order = Order(0.0, 0.0)

  override def combine(x: Order, y: Order): Order =
    Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
}

add(List(Order(1.0, 1.0), Order(1.5, 1.2)))

