package se.randomserver.vmath.test

import se.randomserver.vmath.{Vec, Vec2}
import se.randomserver.vmath.test.VecSuiteGenerators._
import VecSuiteEqualities._

/**
  * Created by patrik on 9/5/16.
  */
class Vec2IntSuite extends VecSuite[Int, Vec2]

class Vec2FloatSuite extends VecSuite[Float, Vec2]

class Vec2DoubleSuite extends VecSuite[Double, Vec2]

class Vec2LongSuite extends VecSuite[Long, Vec2]