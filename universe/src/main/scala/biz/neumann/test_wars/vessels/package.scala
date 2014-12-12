package biz.neumann.test_wars

import org.json4s.JsonAST.{JNull, JString}
import org.json4s.{CustomSerializer, DefaultFormats, ShortTypeHints}
import org.json4s.native.Serialization


package object vessels {

  case class InfiniteImprobabilityDrive()

  implicit val formats = Serialization.formats(ShortTypeHints(List(
    classOf[XWing],
    classOf[TieFighter],
    classOf[Spaceship],
    classOf[Person],
    classOf[HeartOfGold],
    classOf[InfiniteImprobabilityDrive]
  ))) + customSideSerializer



  lazy val customSideSerializer : CustomSerializer[Side] = new CustomSerializer[Side](format => (
      {
        case JString("Neutral") => Neutral
        case JString("Rebels") => Rebels
        case JString("Empire") => Empire
        case JNull => null
      },
      {
        case x: Side => JString(x.toString)
      }
    ))

}
