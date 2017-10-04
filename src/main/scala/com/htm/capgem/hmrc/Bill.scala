package com.htm.capgem.hmrc

class Bill {

  def calculateTotal(items: List[String]): Double = {
    var total: Double = 0.00;

    items.foreach(_ match {
      case "Cola" => total += 0.50
      case "Coffee" => total += 1.00
      case "Cheese Sandwich" => total += 2.00
      case "Steak Sandwich" => total += 4.50
      case _ => ()
    }
    )
    total
  }

}

object Bill extends Bill {
  def apply(orders: List[String]): Double = calculateTotal(orders)
}