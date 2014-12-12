package biz.neumann.test_wars.vessels

import biz.neumann.test_wars.Person

case class TieFighter(pilot: Person = Person.randomImperial) extends Spaceship {
  val attackPower = 2
  var shield = 1
}

object TieFighter extends SpaceshipCompanion[TieFighter] {
  override implicit val manifest: Manifest[TieFighter] = Manifest.classType(classOf[TieFighter])
}
