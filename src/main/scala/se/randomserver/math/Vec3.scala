package se.randomserver.math

/**
  * Created by patrik on 9/4/16.
  */
class Vec3[T](x: T, y: T, z: T)(implicit num: VecIntegral[T])  extends Vec[T, Vec3](x,y, z) {
  import num._
  def *(v: Vec3[T]): Vec3[T] = cross(v)
  def cross(v: Vec3[T]): Vec3[T] = v match {
    case Vec(bx,by, bz) => new Vec3[T](y * bz - z * by,
      z * bx - x * bz,
      x * by - y * bx)
    case _ => throw new DimensionError
  }
}

object Vec3 {
  implicit val factory: VecFactory[Vec3] = new VecFactory[Vec3] {
    override def apply[T](s: T*)(implicit num: VecIntegral[T]): Vec3[T] = s match {
      case Seq(x,y,z) => new Vec3[T](x,y,z)
      case _ => throw new DimensionError
    }
  }
}