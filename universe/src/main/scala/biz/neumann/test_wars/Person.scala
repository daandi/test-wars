package biz.neumann.test_wars

import scala.util.Random

/**
 * User: andi
 * Date: 02.10.14
 * Time: 11:13
 *
 *
 *
 */
case class Person(
                  name: String,
                  var side: Option[String] = None,
                  isJedi : Boolean = false,
                  pilotingSkills : Option[PilotingSkills] = None
                )

object Person {
  def randomRebel : Person =  Person(
    name = "Rebel" + Random.nextInt(),
    side = Some("Rebels"),
    pilotingSkills = Some(PilotingSkills(Probability(0.5),Probability(0.5)) )
  )

  def randomImperial : Person =  Person(
    name = "Imperial" + Random.nextInt(),
    side = Some("Imperium"),
    pilotingSkills = Some(PilotingSkills(Probability(0.4),Probability(0.3)) )
  )
}
