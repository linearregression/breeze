package scalanlp.stats;

import Rand._;
import Math._;

class Gaussian(val mu :Double, val sigma : Double) extends Distribution[Double] {
  private val inner = Rand.gaussian(mu,sigma);

  def probabilityOf(t : Double) = exp(logProbabilityOf(t));
  override def logProbabilityOf(t :Double) =  unnormalizedLogProbabilityOf(t)- log(1.0/sqrt(2 * Math.Pi) - log(sigma)) 
  override def unnormalizedLogProbabilityOf(t :Double) = {val d = (t - mu)/sigma; d *d } 
  override def unnormalizedProbabilityOf(t :Double) = exp(unnormalizedProbabilityOf(t));
  def get() = inner.get();
}