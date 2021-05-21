package hyperconnect

import scala.util.Try

object WeightedAverage {
  def mean(numbers: Array[Int], weights: Array[Int]): Try[Double] = {
    Try {
      val weightedAverage = new WeightedAverage(numbers)
      weightedAverage.calculateMean(weights)
    }
  }

  //  def mean(numbers: Array[Int], weights: Array[Int]): Try[Double] = {
  //    Try {
  //      require(numbers != null)
  //      require(weights != null)
  //      require(numbers.length == weights.length)
  //
  //      var total = 0
  //      var totalWeights = 0
  //      for (i <- numbers.indices) {
  //        total += numbers(i) * weights(i)
  //        totalWeights += weights(i)
  //      }
  //
  //      total / totalWeights
  //    }
  //  }

  def main(args: Array[String]) = {
    // Example case
    val a: Array[Int] = Array(3, 6)
    val b: Array[Int] = Array(4, 2)
    println(WeightedAverage.mean(a, b))
  }
}

class WeightedAverage(numbers: Array[Int]) {
  require(numbers != null)

  def calculateMean(weights: Array[Int]) = {
    require(weights != null)
    require(numbers.length == weights.length)

    val totalSum = (numbers zip weights).map(pair => BigDecimal(pair._1) * pair._2).sum
    val weightSum = weights.foldLeft(BigDecimal(0))(_ + _)
    (totalSum / weightSum).toDouble
  }
}