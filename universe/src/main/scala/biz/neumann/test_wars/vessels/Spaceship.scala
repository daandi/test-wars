package biz.neumann.test_wars.vessels

import biz.neumann.test_wars._

import scala.math

/**
 * User: andi
 * Date: 02.10.14
 * Time: 11:12
 *
 *
 *
 */
trait Spaceship {
  def aim : Probability = Probability(0.5)
  def evade : Probability = Probability(0.5)
  def side : Side = Neutral
  var shield: Int
  def attackPower: Int

  def isOk = shield >= 0

  def beAttacked( aim:Probability, power: Int )  =
    if (
      math.random <= aim.double &&
      math.random >= evade.double
    ) {
      shield = shield - power
      if ( !isOk ) println(s"BOOOOM. $this has been destroyed")
    }


  // Dangerous indirect recuresion, Oh gosh, Normally is terminated when one ship is down
  def engage(o: Spaceship) : Unit = {
    if( isOk ) {
      o.beAttacked( aim, attackPower )
    }
    if (o.isOk) o.engage(this)
  }

}

case class XWing(pilot: Person = Person.randomRebel) extends Spaceship {
  val attackPower = 1
  var shield = 2
}

case class TieFighter(pilot: Person = Person.randomImperial) extends Spaceship {
  val attackPower = 2
  var shield = 1
}

case class UnknownSpaceship(pilot: Person, var shield: Int, attackPower: Int) extends Spaceship