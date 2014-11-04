package person

import biz.neumann.test_wars._
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * User: andi
 * Date: 15.10.14
 * Time: 16:44
 *
 *
 *
 */
class PersonFeatureSpec extends  FeatureSpec with GivenWhenThen {

  info("As a Developer")
  info("I want to have a Person")
  info("which can be part of the Test Wars Universe")
  info("which has defaults and can change sides")

  feature("Person") {
    scenario("Creating a Person gives Person with defaults") {

      Given("a Person created with just the name")
      val person = new Person("Honk")

      Then("the person should have defaults")
      assert(person.isJedi == false)
      assert(person.aim == Probability(0.5))
    }
  }

  feature("Keep it interesting") {
    scenario("A person can change sides") {

      Given("Han Solo")
      val han = new Person("Han Solo")
      assert(han.side == Neutral)

      When("han sees the good in the Rebellion and befriends Luke he changes sides")
      han.side = Rebels

      Then("Han is part of the Rebellion")
      assert(han.side == Rebels)
    }
  }
}
