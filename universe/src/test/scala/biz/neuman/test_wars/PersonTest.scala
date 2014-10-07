package biz.neumann.empire

import biz.neumann.test_wars.Person
import org.scalatest.{ShouldMatchers, FlatSpec}

/**
 * User: andi
 * Date: 02.10.14
 * Time: 11:15
 *
 *
 *
 */
class PersonTest extends FlatSpec with ShouldMatchers {

  "A pilot" should "be defined" in {
    // absolute baseline
    // implicitly testing if class is found and can be instanciated at all
    Person("Torkin Daneb")
  }

  it should "have a name" in {
    Person("Torkin Daneb").name shouldEqual "Torkin Daneb"
  }

  it should "be indifferent of sides when not stated otherwise" in {
    Person("Torkin Daneb").side should be(None)
  }

  it should "be no Jedi by default" in {
    Person("Torkin Daneb").isJedi should be(false)
  }

  it should "be able to change sides" in {
    val han = Person("Torkin Daneb")
    han.side = Some("Rebels")
    han.side should not be empty
    han.side should be( Some("Rebels") )
  }

  it should "have no piloting skills by default" in {
    Person("Torkin Daneb").pilotingSkills should be(None)
  }







}
