package biz.neumann.test_wars.vessels

import biz.neumann.test_wars._
import org.json4s.native._

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

  def serialize : String = Serialization.write(this)
}

trait SpaceshipCompanion[T <: Spaceship] {
  import vessels._
  implicit val manifest: Manifest[T]

  def deserialize(in: String) : T = Serialization.read[T](in)
}



/*case class UnknownSpaceship(pilot: Person, var shield: Int, attackPower: Int) extends Spaceship {
  override def serialize: Json = ???

  override def deserialize[A >: Spaceship]: A = ???
}*/
