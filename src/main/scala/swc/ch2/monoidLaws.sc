import swc.ch2.{Monoid, Semigroup}
import swc.ch2.Monoid._

val booleanMonoid = Monoid[Boolean]
booleanMonoid.combine(true, booleanMonoid.combine(true, false)) ==
booleanMonoid.combine(booleanMonoid.combine(true, true), false)
booleanMonoid.combine(true, booleanMonoid.empty) == true
booleanMonoid.combine(false, booleanMonoid.empty) == false

val booleanSetMonoid = Monoid[Set[Boolean]]
val booleanSet = Set(true)
val booleanSet2 = Set(false)
val booleanSet3 = Set(true, false)
booleanSetMonoid.combine(booleanSet, booleanSetMonoid.empty) == booleanSet
booleanSetMonoid.combine(
  booleanSet,
  booleanSetMonoid.combine(booleanSet2, booleanSet3)
) ==
booleanSetMonoid.combine(
  booleanSetMonoid.combine(booleanSet, booleanSet2),
  booleanSet3
)

val intSetMonoid = Monoid[Set[Int]]
intSetMonoid.combine(Set(1, 2), Set(2, 3))

val setIntersectSemiGroup: Semigroup[Set[String]] = Monoid[Set[String]]
implicitly[Semigroup[Set[String]]]

val stringSet1 = Set("1", "2")
val stringSet2 = Set("2", "3")
setIntersectSemiGroup.combine(stringSet1, stringSet2)


