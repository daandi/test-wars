package biz.neumann.test_wars

/**
 * Copyright (C) 2014 Clueda AG.
 * This work is proprietary and confidential. Any distribution,
 * reproduction, or modification is strictly prohibited under any
 * circumstances without the express prior written permission of Clueda
 * AG. All rights reserved.
 */
sealed trait Side
case object Neutral extends Side
case object Empire extends Side
case object Rebels extends Side