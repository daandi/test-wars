package biz.neumann.test_wars.vessels

case class HeartOfGold(
                        var shield : Int = Double.PositiveInfinity.toInt ,
                        var engine : Option[InfiniteImprobabilityDrive] = None
                        ) extends Spaceship {
  override def attackPower: Int = 0
}

object HeartOfGold extends SpaceshipCompanion[HeartOfGold] {
  override implicit val manifest: Manifest[HeartOfGold] = Manifest.classType(classOf[HeartOfGold])
}
