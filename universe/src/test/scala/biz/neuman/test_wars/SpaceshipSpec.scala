package biz.neuman.test_wars

import biz.neumann.test_wars.Person
import biz.neumann.test_wars.vessels.Spaceship
import org.scalatest.FunSuite
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
    "have a pilot " in new TestShip {
      pilot mustEqual anakin
    }
    "is ok" in new TestShip {
      isOk must beTrue
    }
    "armor below 0 => ship is not ok" in new TestShip {
      armor = -1
      isOk must beFalse
    }

  }

  class TestShip extends Spaceship with Scope {
    override def pilot: Person = anakin
    override def attackPower: Int = 10
    override var armor: Int = 5
  }

  lazy val anakin = Person(name = "Anakin", isJedi = true)




}
