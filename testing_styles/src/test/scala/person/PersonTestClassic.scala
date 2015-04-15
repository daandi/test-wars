package person

import biz.neumann.test_wars._
import org.scalatest.FunSuite

class PersonTestClassic extends  FunSuite {

  test("Person can be created without exception") {
    assert( Person("Nobody").isInstanceOf[Person] == true )
  }

  test("Person is Neutral by default") {
    assert( person.side == Neutral )
  }

  test("Person is no Jedi by default") {
    assert( person.isJedi == false )
  }

  test("Person has default aiming prob of 50%") {
    assert( person.aim == Probability(0.5) )
  }

  test("Person can change sides ad libitum to the Empire")  {
    val anakin = Person("Anakin", isJedi = true)
    anakin.side = Empire
    assert( anakin.side == Empire )
  }
  test("Person can change sides ad libitum to the Rebels")  {
    val han = Person("Han Solo")
    assert( han.side == Neutral )
    han.side = Rebels
    assert( han.side == Rebels )
  }

  def person = Person("Honk")

}
