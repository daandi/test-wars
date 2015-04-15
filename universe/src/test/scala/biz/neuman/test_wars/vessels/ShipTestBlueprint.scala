package biz.neuman.test_wars.vessels

import biz.neumann.test_wars.{Neutral, Probability}
import biz.neumann.test_wars.vessels._
import org.specs2.Specification
import org.specs2.specification.core.{SpecStructure, Fragments}

trait ShipTestBlueprint[S <: Spaceship]  { self: Specification =>

  // Things you have to implement when you want to test
  def specificTests : SpecStructure
  def getInstance: S
  def spaceshipFactory :SpaceshipCompanion[S]
  def serializedRepresentation : String

  // general test description
  def generalTests =s2"""
A $ship
  has to be a case class                                                      $caseClass
  has shield                                                                  $hasShield
  has attack power                                                            $hasAttackPower
$ship Shield
  ship armor can be changed which affects the isOK state                      $changeShield
Serialisation and Deserialisation of $ship
  A $ship can be serialized                                                   $serialized
  A $ship is the same after serializing and deserializing                     $serialisationDeserialisation
"""

  // plumbing, boilerplate
  def is : SpecStructure  = specificTests ^ generalTests
  lazy val instance : S = getInstance
  def ship = instance.getClass.getSimpleName

  // implementation of general tests
  def serialized = instance.serialize mustEqual serializedRepresentation
  def serialisationDeserialisation = spaceshipFactory.deserialize( instance.serialize ) mustEqual instance
  def hasShield = instance.shield must not beNull
  def hasAttackPower = instance.shield must not beNull
  def goodShip = instance.isOk must beTrue

  def changeShield = {
    val shipToBreak : S = getInstance
    shipToBreak.isOk must beTrue
    shipToBreak.shield = -1
    shipToBreak.isOk must beFalse
  }

  def isCaseClass(v: Any): Boolean = {
    import reflect.runtime.universe._
    val typeMirror = runtimeMirror(v.getClass.getClassLoader)
    val instanceMirror = typeMirror.reflect(v)
    val symbol = instanceMirror.symbol
    symbol.isCaseClass
  }

  def caseClass = isCaseClass(getInstance)

}
