package biz.neumann.test_wars.vessels

import biz.neumann.test_wars.{Empire, Side, Person}

case class TieFighter(pilot: Person = Person.randomImperial) extends Spaceship {
  override def side: Side = Empire
  val attackPower = 2
  var shield = 1
}

object TieFighter extends SpaceshipCompanion[TieFighter] {
  override implicit val manifest: Manifest[TieFighter] = Manifest.classType(classOf[TieFighter])
}
