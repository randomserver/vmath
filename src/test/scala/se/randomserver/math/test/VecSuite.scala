package se.randomserver.math.test

import scala.language.higherKinds
import org.scalacheck.{Arbitrary}
import org.scalatest._
import prop._
import se.randomserver.math.{Vec, VecIntegral}


/**
  * Created by patrik on 9/4/16.
  */
abstract class VecSuite[T: Arbitrary, V[T] <: Vec[T, V]](tolerance: T)(implicit genVec: Arbitrary[V[T]], num: VecIntegral[T])
  extends PropSpec with PropertyChecks {

  import num._

  property("associative add") {
    forAll { (a: V[T], b: V[T]) =>
      assert((a + b).compare(b + a) < tolerance)
    }
  }

  property("scalar distributed") {
    forAll { (a: V[T], b: V[T], s: T) =>
      assert((a + b) * s == a * s + b * s)
    }
  }

  property("scalar distributed2") {
    forAll { (a: V[T], s1: T, s2: T) =>
      assert(a * (s1 + s2) == a * s1 + a * s2)
    }
  }

  property("scalar associative") {
    forAll() { (c: T, d: T, v: V[T]) =>
      assert(v * (c * d) == (v * d) * c)
    }
  }

  property("dot associative") {
    forAll { (u: V[T], v: V[T]) =>
      assert(v.dot(u) == u.dot(v))
    }
  }

  property("dot square abs") {
    forAll { (u: V[T]) =>
      assert(u.dot(u) == u.abs * u.abs)
    }
  }
}
