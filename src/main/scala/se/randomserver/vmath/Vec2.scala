package se.randomserver.vmath

/**
  * Created by patrik on 9/4/16.
  */
class Vec2[T](val x: T,val y: T)(implicit num: VecIntegral[T])  extends Vec[T, Vec2](x,y) {
  import num._
  def *(v2: Vec2[T]): T = v2 match {
    case Vec(x2, y2) => x*y2 - x2*y
  }
}

object Vec2 {
  implicit val factory: VecFactory[Vec2] = new VecFactory[Vec2] {
    override def apply[T](s: T*)(implicit num: VecIntegral[T]): Vec2[T] = s match {
      case Seq(x,y) => new Vec2[T](x,y)
      case _ => throw new DimensionError
    }
  }
}