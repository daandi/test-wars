package biz.neuman.test_wars.vessels

import biz.neumann.test_wars.{Rebels, Person}
import biz.neumann.test_wars.vessels.{SpaceshipCompanion, XWing}
import org.specs2.Specification
import org.specs2.specification.core.{SpecStructure, Fragments}

class XWingSpec extends Specification with ShipTestBlueprint[XWing] {
  override def specificTests: SpecStructure =
s2"""
XWing Specific Tests
  XWing needs a rebel pilot               $pilot
"""
  override def getInstance: XWing = new XWing(Person("Luke Skywalker", Rebels, true))
  override def serializedRepresentation: String =
    """{"jsonClass":"XWing","pilot":{"jsonClass":"Person","name":"Luke Skywalker","side":"Rebels","isJedi":true,"aim":{"double":0.5},"evade":{"double":0.5}},"shield":2}"""
  override def spaceshipFactory: SpaceshipCompanion[XWing] = XWing

  def pilot = new XWing( Person.randomImperial ) must throwA(new Exception("Only the Rebels have XWings!"))
}
