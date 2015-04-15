package biz.neuman.test_wars.vessels

import biz.neumann.test_wars.vessels.{InfiniteImprobabilityDrive, SpaceshipCompanion, HeartOfGold}
import org.specs2.Specification

class HeartOfGoldSpec extends Specification with ShipTestBlueprint[HeartOfGold] {
  // Things you have to implement when you want to test
  override def specificTests = s2""""""
  override def serializedRepresentation: String = """{"jsonClass":"HeartOfGold","shield":2147483647,"engine":{"jsonClass":"package$InfiniteImprobabilityDrive"}}"""
  override def getInstance: HeartOfGold = new HeartOfGold( engine = Some(InfiniteImprobabilityDrive()) )
  override def spaceshipFactory: SpaceshipCompanion[HeartOfGold] = HeartOfGold
}
