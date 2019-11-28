package se.randomserver.vmath

import scala.math.Numeric.IntIsIntegral

/**
  * Created by patrik on 9/4/16.
  */
trait VecIntegral[T] extends Integral[T] {
  def sqrt(x: T): T
}

object VecIntegral {
  implicit object IntIsVecIntegral extends VecIntegral[Int] with Numeric.IntIsIntegral with Ordering.IntOrdering {
    def sqrt(x: Int): Int = math.sqrt(x).round.toInt
  }
  implicit object LongIsVecIntegral extends VecIntegral[Long] with Numeric.LongIsIntegral with Ordering.LongOrdering {
    def sqrt(x: Long): Long = math.sqrt(x).round
  }
  implicit object FloatIsVecIntegral extends VecIntegral[Float] with Numeric.FloatAsIfIntegral with Ordering.FloatOrdering {
    def sqrt(x: Float): Float = math.sqrt(x).toFloat
  }
  implicit object DoubleIsVecIntegral extends VecIntegral[Double] with Numeric.DoubleAsIfIntegral with Ordering.DoubleOrdering {
    def sqrt(x: Double): Double = math.sqrt(x)
  }
}