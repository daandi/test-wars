package biz.neuman.test_wars

import biz.neumann.test_wars.vessels.{XWing, TieFighter, Spaceship}

import org.specs2.Specification

/**
 * User: andi
 * Date: 02.10.14
 * Time: 13:35
 *
 *
 *
 */
class SpaceshipAcceptanceSpec extends Specification {def is =
s2"""
Ships models
  TieFighter                         ${ TieFighter() must beAnInstanceOf[Spaceship] }
  X-Wing                             ${ XWing() must beAnInstanceOf[Spaceship] }
"""

}
