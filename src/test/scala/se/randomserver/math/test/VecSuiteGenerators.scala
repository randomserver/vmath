package se.randomserver.math.test

import org.scalacheck.{Arbitrary, Gen}
import org.scalactic.Equality

import scala.language.higherKinds
import scala.language.existentials
import se.randomserver.math.{Vec, Vec2, Vec3, VecIntegral}

/**
  * Created by patrik on 9/5/16.
  */
object VecSuiteGenerators {
  import org.scalautils.TripleEquals._
  import org.scalautils.Tolerance._

  implicit val arbDouble: Arbitrary[Double] = Arbitrary(Gen.choose[Double](-10d, 10d))
  implicit val arbFloat: Arbitrary[Float] = Arbitrary(Gen.choose[Float](-10f, 10f))
  implicit val arbLong: Arbitrary[Long] = Arbitrary(Gen.choose[Long](-10l, 10l))
  implicit val arbInt: Arbitrary[Int] = Arbitrary(Gen.choose[Int](-10, 10))

  implicit def arbVec2[T: Arbitrary](implicit num: VecIntegral[T]): Arbitrary[Vec2[T]] = Arbitrary(for {
      i <- Arbitrary.arbitrary[T]
      j <- Arbitrary.arbitrary[T]
    } yield new Vec2[T](i, j))

  implicit def arbVec3[T: Arbitrary](implicit num: VecIntegral[T]): Arbitrary[Vec3[T]] = Arbitrary(for {
    i <- Arbitrary.arbitrary[T]
    j <- Arbitrary.arbitrary[T]
    w <- Arbitrary.arbitrary[T]
  } yield new Vec3[T](i, j, w))


}