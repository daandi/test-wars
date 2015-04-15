package biz.neumann.test_wars.vessels

import biz.neumann.test_wars.{Side, Rebels, Person}

case class XWing(pilot: Person = Person.randomRebel,  var shield : Int = 2) extends Spaceship {
  override def side: Side = Rebels
  val attackPower = 1
  if (pilot.side != Rebels) throw new Exception("Only the Rebels have XWings!")
}

object XWing extends SpaceshipCompanion[XWing] {
  override implicit val manifest: Manifest[XWing] = Manifest.classType(classOf[XWing])
}
