import biz.neumann.test_wars.{Neutral, Probability}
import biz.neumann.test_wars.vessels.Spaceship
import org.specs2.Specification


/**
 * Copyright (C) 2014 Clueda AG.
 * This work is proprietary and confidential. Any distribution,
 * reproduction, or modification is strictly prohibited under any
 * circumstances without the express prior written permission of Clueda
 * AG. All rights reserved.
 */
class SpaceShipSpec extends Specification  {def is= s2"""
A spaceship
  has shield                                                                  $hasShield
  has attack power                                                            $hasAttackPower
  has a aim, which defaults to 50% accuracy                                   $aim
  has a chance to evade, which defaults to 50%                                $evade
  belongs to a side which by default is Neutral                               $side

Spaceship Shield
  a ship with shield left is ok                                               $goodShip
  a ship with shield below 0 is broken                                        $badShip
  ship armor can be changed which affects the isOK state                      $changeShield

Spaceship Battle
  a ship can engage another ship will not end in an endless loop              $pending
  it will not engage if it is not Ok                                          $pending
  after being engaged by another ship it will engage the other ship
  it will engage the other ship till one ship is no longer ok
"""


  def hasShield = spaceship.shield must not beNull
  def hasAttackPower = spaceship.shield must not beNull

  def goodShip = {
    okShip.shield must be greaterThan(-1)
    okShip.isOk must beTrue
  }
  def badShip  = {
    brokenShip.shield must be lessThan(0)
    brokenShip.isOk must beFalse
  }
  def changeShield = {
    val ship = brokenShip
    ship.isOk must beFalse
    ship.shield = 10
    ship.isOk must beTrue
  }
  def brokenEngage = {
    val bs = brokenShip
    bs.engage(spaceship)
  }

  def okShip = new Spaceship {
    override def attackPower: Int = ???
    override var shield: Int = 0
  }

  def brokenShip = new Spaceship {
    override def attackPower: Int = ???
    override var shield: Int = -1
  }



  def engageLoop = pending


  def spaceship = new Spaceship {
    override var shield: Int = 2
    override def attackPower: Int = 1
  }

  def aim = spaceship.aim mustEqual Probability(0.5)
  def evade = spaceship.evade mustEqual Probability(0.5)
  def side = spaceship.side mustEqual Neutral


}

