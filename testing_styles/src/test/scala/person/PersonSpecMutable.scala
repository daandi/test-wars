package person


import biz.neumann.test_wars._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class PersonSpecMutable extends Specification {

  "A Person" should {
    "be created without exception" in  {
      Person("Nobody") must not throwA(new Exception)
    }
  }

  "Person default values" should {
    "be Neutral by default" in new TestPerson {
      side mustEqual Neutral
    }
    "be no Jedi by default" in new TestPerson {
      isJedi must beFalse
    }
    "have aiming prob of 50% " in new TestPerson {
      aim mustEqual Probability(0.5)
    }
    "have default chance of evading 50%" in new TestPerson {
      evade mustEqual Probability(0.5)
    }

  }

  "Person can change sides ad libitum" should {
    "to the empire" in {
      val anakin = Person("Anakin")
      anakin.side mustEqual Neutral
      anakin.side = Empire
      anakin.side mustEqual Empire
    }
    "to Rebels" in {
      val han = Person("Han Solo")
      han.side mustEqual Neutral
      han.side = Rebels
      han.side mustEqual Rebels
    }
  }

  class TestPerson(name: String = "Honk") extends Person(name) with Scope

}
