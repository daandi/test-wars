package person

import biz.neumann.test_wars._
import org.specs2.Specification


class PersonSpec extends Specification {def is = s2"""
Person
  can be created without exception            $create

Person default values
  is Neutral by default                       $defaultSide
  is no Jedi by default                       $isTheForceWithHim
  has default aiming prob of 50%              $defaultAim
  has default chance of evading 50%           $defaultEvade

Person can change sides ad libitum
  to the empire                               $becomeEvil
  to Rebels                                   $becomeRebel
"""

  def create = Person("Nobody") must not throwA(new Exception)
  def defaultSide = person.side mustEqual Neutral
  def isTheForceWithHim = person.isJedi must beFalse
  def defaultAim = person.aim mustEqual Probability(0.5)
  def defaultEvade = person.evade mustEqual Probability(0.5)

  def becomeEvil = {
    val anakin = Person("Anakin")
    anakin.side mustEqual Neutral
    anakin.side = Empire
    anakin.side mustEqual Empire
  }

  def becomeRebel = {
    val anakin = Person("Han Solo")
    anakin.side mustEqual Neutral
    anakin.side = Rebels
    anakin.side mustEqual Rebels
  }

  def person = Person("Honk")

}
