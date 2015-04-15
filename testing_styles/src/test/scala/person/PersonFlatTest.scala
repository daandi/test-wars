package person

import biz.neumann.test_wars._
import org.scalatest.{FlatSpec, ShouldMatchers}

class PersonFlatTest extends FlatSpec with ShouldMatchers {

  "A Person" should "be created without exception" in {
    Person("Nobody") shouldBe a [Person]
  }

  it should "be Neutral by default" in {
    person.side should be(Neutral)
  }

  it should "be no Jedi by default" in {
    person.isJedi should be(false)
  }

  it should ("have default aiming prob of 50%") in {
    person.aim should be( Probability(0.5) )
  }

 "Person can change sides ad libitum " should "to the Empire" in  {
    val anakin = Person("Anakin", isJedi = true)
    anakin.side = Empire
    anakin.side should be( Empire )
  }

  it should "to the Rebels" in  {
    val han = Person("Han Solo")
    han.side should be( Neutral )
    han.side = Rebels
   han.side should be ( Rebels )
  }

  def person = Person("Honk")

}
