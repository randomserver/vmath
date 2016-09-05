package se.randomserver.math.test

import scala.language.higherKinds
import org.scalacheck.{Arbitrary}
import org.scalatest._
import prop._
import se.randomserver.math.{Vec, VecIntegral}


/**
  * Created by patrik on 9/4/16.
  */
abstract class VecSuite[T: Arbitrary, V[T] <: Vec[T, V]](implicit genVec: Arbitrary[V[T]], num: VecIntegral[T])
  extends PropSpec with PropertyChecks {

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
