package se.randomserver.vmath
import scala.language.higherKinds


class DimensionError extends Error

trait VecFactory[V[_]] {
  def apply[T](s: T*)(implicit num: VecIntegral[T]): V[T]
}

abstract class Vec[T, V[T] <: Vec[T, V]](val elems: T*)(implicit num: VecIntegral[T], factory: VecFactory[V])
    extends Ordered[V[T]] {
  import num._

  def +(v: V[T]): V[T] = factory(elems.zip(v.elems).map { case (a, b) => a + b }:_*)
  def -(v: V[T]): V[T] = this + (-v)
  def dot(v: V[T]): T = elems.zip(v.elems).map { case (a,b) => a * b }.sum
  def unary_-(): V[T] = map(_.unary_-())
  def *(scalar: T): V[T] = map(_ * scalar)
  def abs: T = sqrt(elems.map(a => a * a).sum)
  def normalize(): V[T] = {
    val l: T = elems.sum
    factory(elems.map(a => quot(a,l)):_*)
  }
  def apply(n: Int): T = elems(n)
  def map[C](f: T => C)(implicit n: VecIntegral[C], fa: VecFactory[V]): V[C] = fa(elems.map(f):_*)

  override def equals(that: Any): Boolean = that match {
    case that: Vec[T,V] => elems.zip(that.elems).forall { case (a,b) => a == b }
    case _ => false
  }
  override def compare(that: V[T]): Int = (abs - that.abs).toInt

  override def toString: String = elems.mkString("[", ", ", "]")
}

object Vec {
  def unapplySeq[T, V[T] <: Vec[T, V]](v: Vec[T, V]): Option[Seq[T]] = Some(v.elems)
  def apply[T](x: T, y: T)(implicit num: VecIntegral[T]): Vec2[T] = new Vec2[T](x,y)
  def apply[T](x: T, y: T, z: T)(implicit num: VecIntegral[T]): Vec3[T] = new Vec3[T](x,y,z)
}
