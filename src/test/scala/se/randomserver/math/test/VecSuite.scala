package se.randomserver.math.test

import org.scalacheck.{Arbitrary, Gen, Properties}
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest._
import prop._
import se.randomserver.math.{Vec, Vec2, VecFactory, VecIntegral}

import reflect.runtime.universe._

/**
  * Created by patrik on 9/4/16.
  */
class VecSuite[T, V[T] <: Vec[T,V]](implicit vectorGen: Gen[V[T]]) extends PropSpec with PropertyChecks {
  implicit lazy val arbVector: Arbitrary[V[T]] = Arbitrary(vectorGen)

  property("Commutative add") {
    forAll { (a: V[T], b: V[T]) =>
      println(a.toString)
      println(b.toString)
      a + b == b + a
    }
  }
}

