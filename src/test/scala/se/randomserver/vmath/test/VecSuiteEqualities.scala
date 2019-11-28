package se.randomserver.vmath.test
import scala.language.higherKinds
import org.scalactic.{Equality, TolerantNumerics}
import se.randomserver.vmath.Vec

/**
  * Created by patrik on 2016-09-06.
  */
object VecSuiteEqualities {
  import org.scalactic.Tolerance._
  import org.scalactic.TripleEquals._

  class VecDoubleEquality[V[Double] <: Vec[Double, V]] extends Equality[V[Double]] {
    override def areEqual(a: V[Double], b: Any): Boolean = (a,b) match {
      case (lhs: Vec[Double, V], rhs: Vec[Double, V]) => lhs.elems.zip(rhs.elems).forall {
        case (e1, e2) => {
          val tolerance = if(e1 == Double.PositiveInfinity || e1 == Double.NegativeInfinity) 0.01d else Set(e1.abs, 1d).max*0.01d
          if (e1.isNaN && e2.isNaN) true
          else e1 === e2 +- tolerance
        }
      }
      case _ => false
    }
  }
  implicit def doubleVEq[V[Double] <: Vec[Double, V]] = new VecDoubleEquality[V]

  class VecFloatEquality[V[Float] <: Vec[Float, V]] extends Equality[V[Float]] {
    override def areEqual(a: V[Float], b: Any): Boolean = (a,b) match {
      case (lhs: Vec[Float, V], rhs: Vec[Float, V]) => lhs.elems.zip(rhs.elems).forall {
        case (e1, e2) => {
          val tolerance = if(e1 == Float.PositiveInfinity || e1 == Float.NegativeInfinity) 0.01f else Set(e1.abs, 1f).max*0.01f
          if (e1.isNaN && e2.isNaN) true
          else e1 === e2 +- tolerance
        }
      }
      case _ => false
    }
  }
  implicit def floatVEq[V[Float] <: Vec[Float, V]] = new VecFloatEquality[V]

  implicit val doubleEq: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.01d)
  implicit val floatEq: Equality[Float] = TolerantNumerics.tolerantFloatEquality(0.01f)
}
