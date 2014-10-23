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
                  var side: Side = Neutral,
                  isJedi : Boolean = false,
                  aim: Probability = Probability(0.5),
                  evade: Probability = Probability(0.5)
                )

object Person {
  def randomRebel : Person =  Person(
    name = "Rebel" + Random.nextInt(),
    side = Rebels,
    evade = Probability(0.6)
  )

  def randomImperial : Person =  Person(
    name = "Imperial" + Random.nextInt(),
    side = Empire,
    evade =  Probability(0.3),
    aim =  Probability(0.55)
  )
}
