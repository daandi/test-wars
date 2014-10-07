package biz.neumann.test_wars

/**
 * User: andi
 * Date: 02.10.14
 * Time: 11:56
 *
 *
 *
 */
case class Probability(d : Double) {
  if (d < 0.0 || d > 1.0 ) throw new Exception(s"Probability has to be between 0 and 1")
}