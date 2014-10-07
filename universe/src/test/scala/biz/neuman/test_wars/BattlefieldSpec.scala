package biz.neuman.test_wars

import biz.neumann.test_wars.Battlefield
import biz.neumann.test_wars.vessels.{XWing, TieFighter}
import org.specs2.Specification

/**
 * Copyright (C) 2014 Clueda AG.
 * This work is proprietary and confidential. Any distribution,
 * reproduction, or modification is strictly prohibited under any
 * circumstances without the express prior written permission of Clueda
 * AG. All rights reserved.
 */
class BattlefieldSpec extends Specification {def is=s2"""
The Battelfield
  $sequential
  starts with no ships                              $startEmpty
  there can be a ship added                         $addShip
  ships are unique and can't be added twice         $shipsAreUnique
  the battlefield can be cleaned                    $clean
The Battle
  no ships no casualties                            $noShips
  ships on the same side don't attack each other    $sameSide
  ships on different sides fight                    $battle
"""


  lazy val tieFighter1 = TieFighter()

  def startEmpty = battlefield.ships must beEmpty
  def addShip = {
    val xWing = XWing()
    battlefield addShip xWing
    battlefield.ships must contain(xWing)
  }

  def shipsAreUnique = {
    battlefield addShip tieFighter1
    val shipsBeforeDup = battlefield.ships
    battlefield addShip tieFighter1

    battlefield.ships mustEqual shipsBeforeDup
  }

  def clean = {
    battlefield.tabulaRasa
    battlefield.shipCount mustEqual 0
  }

  def noShips = freshBattle.doBattle must beEmpty
  def sameSide = {
    val bf = freshBattle
    bf addShip XWing()
    bf addShip XWing()

    bf.doBattle mustEqual  Map("Rebels" -> Map("losses" -> 0, "ok" -> 2))
  }

  def battle = {
    val bf = freshBattle
    bf addShip TieFighter()

    bf addShip XWing()

    List("Rebels","Imperium").flatMap( bf.doBattle.get(_).flatMap(_.get("losses")) ) must contain(1)

  }

  lazy val battlefield = freshBattle
  def freshBattle = new Battlefield {}

}
