package biz.neuman.test_wars.vessels

import biz.neumann.test_wars.Person
import biz.neumann.test_wars.vessels.Spaceship
import org.specs2.matcher.Scope
import org.specs2.mutable.Specification

/**
 * User: andi
 * Date: 02.10.14
 * Time: 13:35
 *
 *
 *
 */
class SpaceshipSpec extends Specification {

  "A Spaceship" should {
    "is ok" in new TestShip {
      isOk must beTrue
    }
    "armor below 0 => ship is not ok" in new TestShip {
      shield = -1
      isOk must beFalse
    }

  }

  class TestShip extends Spaceship with Scope {
    override def attackPower: Int = 10
    override var shield: Int = 5
  }

  lazy val anakin = Person(name = "Anakin", isJedi = true)




}
