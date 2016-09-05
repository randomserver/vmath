package se.randomserver.math.test

import org.scalacheck.Arbitrary
import se.randomserver.math.{Vec2, Vec3, VecIntegral}

/**
  * Created by patrik on 9/5/16.
  */
object VecSuiteGenerators {
  implicit def arbVec2[T: Arbitrary](implicit num: VecIntegral[T]): Arbitrary[Vec2[T]] = Arbitrary(for {
    a <- Arbitrary.arbitrary[T]
    b <- Arbitrary.arbitrary[T]
  } yield new Vec2[T](a, b))

  implicit def arbVec3[T: Arbitrary](implicit num: VecIntegral[T]): Arbitrary[Vec3[T]] = Arbitrary(for {
    a <- Arbitrary.arbitrary[T]
    b <- Arbitrary.arbitrary[T]
    c <- Arbitrary.arbitrary[T]
  } yield new Vec3[T](a, b, c))
}
