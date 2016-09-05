package se.randomserver.math.test

import scala.language.higherKinds
import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest._
import prop._
import se.randomserver.math.{Vec, Vec2, VecFactory, VecIntegral}

/**
  * Created by patrik on 9/4/16.
  */
abstract class VecSuite[T: Arbitrary, V[T] <: Vec[T, V]] extends PropSpec with PropertyChecks {
  def vectorGen: Gen[V[T]]
  implicit lazy val arbVector: Arbitrary[V[T]] = Arbitrary(vectorGen)

  property("associative add") {
    forAll { (a: V[T], b: V[T]) =>
      a + b == b + a
    }
  }

  property("scalar multiplication") {
    forAll { (a: V[T], b: V[T], s: T) =>
      (a + b) * s == a * s + b * s
    }
  }
}


class Vec2Suite[T: Arbitrary](implicit num: VecIntegral[T]) extends VecSuite[T, Vec2] {
  override def vectorGen: Gen[Vec2[T]] = for {
    a <- Arbitrary.arbitrary[T]
    b <- Arbitrary.arbitrary[T]
  } yield new Vec2[T](a, b)
}

class Vec2IntSuite extends Vec2Suite[Int]

class Vec2FloatSuite extends Vec2Suite[Float]

class Vec2DoubleSuite extends Vec2Suite[Double]

class Vec2LongSuite extends Vec2Suite[Long]
