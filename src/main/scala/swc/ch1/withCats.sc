import cats.Show
import cats._
import cats.implicits._
import swc.ch1.Cat

import java.util.Date

val showInt = Show.apply[Int]
val showString = Show.apply[String]

val intAsString: String = showInt.show(123)
val stringASString: String = showString.show("abc")

import cats.syntax.show._

val shownInt = 123.show
val shownString = "abc".show

implicit val dateShow: Show[Date] = Show.fromToString[Date]

val shownDate = new Date().show

val eqInt = Eq[Int]
eqInt.eqv(123, 123)
eqInt.eqv(123, 124)
123 === 123
123 =!= 124

Option(1) === Option.empty
1.some === none
1.some =!= none

implicit val dateEq: Eq[Date] =
  Eq.instance[Date] { (date1, date2) =>
    date1.getTime === date2.getTime
  }
val x = new Date()
val y = new Date()
x === x
x === y

val cat1 = Cat("Garfield", 38, "orange and black")
val cat2 = Cat("Heathcliff", 33, "orange and black")

val optionCat1 = Option(cat1)
val optionCat2 = Option(cat2)

implicit val catEq: Eq[Cat] =
  Eq.instance[Cat] { (cat1, cat2) =>
    (cat1.age === cat2.age) &&
      (cat1.name === cat2.name) &&
      (cat1.color === cat2.color)
  }

cat1 === cat2
cat1 =!= cat2
optionCat1 === optionCat2
optionCat1 =!= optionCat2
