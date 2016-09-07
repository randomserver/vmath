package se.randomserver.math.test

import org.scalactic.Equality
import se.randomserver.math.{Vec, Vec2}
import se.randomserver.math.test.VecSuiteGenerators._
import se.randomserver.math.test.VecSuiteEqualities._

/**
  * Created by patrik on 9/5/16.
  */
class Vec2IntSuite extends VecSuite[Int, Vec2]

class Vec2FloatSuite extends VecSuite[Float, Vec2]

class Vec2DoubleSuite extends VecSuite[Double, Vec2]

class Vec2LongSuite extends VecSuite[Long, Vec2]