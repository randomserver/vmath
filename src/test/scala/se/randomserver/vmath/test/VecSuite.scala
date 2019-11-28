package se.randomserver.vmath.test

import scala.language.higherKinds
import org.scalacheck.Arbitrary
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest._
import prop._
import se.randomserver.vmath.{Vec, Vec2, VecIntegral}

/**
  * Created by patrik on 9/4/16.
  */
abstract class VecSuite[T: Arbitrary, V[T] <: Vec[T, V]](implicit genVec: Arbitrary[V[T]], vecEq: Equality[V[T]], eq: Equality[T], num: VecIntegral[T])
  extends PropSpec with PropertyChecks {
  import num._


  property("associative add") {
    forAll { (a: V[T], b: V[T]) =>
      assert((a + b).===(b + a))
    }
  }

  property("scalar distributed") {
    forAll { (a: V[T], b: V[T], s: T) =>
      assert((a + b) * s === a * s + b * s)
    }
  }

  property("scalar distributed2") {
    forAll { (a: V[T], s1: T, s2: T) =>
      assert(a * (s1 + s2) === a * s1 + a * s2)
    }
  }

  property("scalar associative") {
    forAll() { (c: T, d: T, v: V[T]) =>
      assert(v * (c * d) === (v * d) * c)
    }
  }

  property("dot associative") {
    forAll { (u: V[T], v: V[T]) =>
      assert(v.dot(u) === u.dot(v))
    }
  }

  property("dot distributed") {
    forAll { (a: V[T], b: V[T], c: V[T]) =>
      assert( (a dot b + c) === (a dot b) + (a dot c))
    }
  }
}
