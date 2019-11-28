package se.randomserver.vmath.test


import se.randomserver.vmath.Vec3

import se.randomserver.vmath.test.VecSuiteGenerators._
import VecSuiteEqualities._
/**
  * Created by patrik on 9/5/16.
  */
class Vec3IntSuite extends VecSuite[Int, Vec3]

class Vec3FloatSuite extends VecSuite[Float, Vec3]

class Vec3DoubleSuite extends VecSuite[Double, Vec3]

class Vec3LongSuite extends VecSuite[Long, Vec3]
