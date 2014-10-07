package biz.neumann.test_wars

import biz.neumann.test_wars.vessels.Spaceship

import scala.util.Random
/**
 * User: andi
 * Date: 02.10.14
 * Time: 13:57
 *
 *
 *
 */
trait Battlefield {

  type BattleResult =  Map[String,Map[String,Int]]

  private var vessels : Set[Spaceship] = Set()

  def shipCount = vessels.size
  def ships = vessels.toList
  def tabulaRasa: Unit = vessels = Set()

  def addShip(v: Spaceship) : Unit = vessels += v


  def doBattle : BattleResult = {
    vessels = Random.shuffle(vessels)

    for {
      v <- vessels
      o <- vessels
      if o != v // do not fight against self ;)
      if o.pilot.side != v.pilot.side
    } v engage o
    battleResult(vessels.toVector)
  }

  def battleResult(vessels: Seq[Spaceship]) : BattleResult =
    vessels.
      groupBy(_.pilot.side getOrElse "Neutral").
      mapValues{ vs =>
        val (ok, losses) = vs.partition( _.isOk )
        Map(
          "losses" -> losses.size,
          "ok" -> ok.size
        )
    }
}
