package biz.neumann.test_wars.vessels

import biz.neumann.test_wars.{Probability, Person}

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
  def pilot: Person
  var armor: Int
  def attackPower: Int

  def isOk = armor >= 0

  def beAttacked( accuracy: Option[Probability], power: Int )  = {
    if (
      math.random <= accuracy.map(_.d).getOrElse(0.0) &&
      math.random >= pilot.pilotingSkills.map(_.evade.d).getOrElse(0.0)
    ) {
      armor = armor - power
    }
  }

  // Dangerous indirect recuresion, Oh gosh, Normally is terminated when one ship is down
  def engage(o: Spaceship) : Unit = {
    if( isOk ) {
      o.beAttacked( pilot.pilotingSkills.map(_.aim), attackPower )
    }
    if (o.isOk) o.engage(this)
  }

}

case class XWing(pilot: Person = Person.randomRebel) extends Spaceship{
  val attackPower = 1
  var armor = 2
}

case class TieFighter(pilot: Person = Person.randomImperial) extends Spaceship {
  val attackPower = 2
  var armor = 1
}

case class UnknownSpaceship(pilot: Person, var armor: Int, attackPower: Int) extends Spaceship