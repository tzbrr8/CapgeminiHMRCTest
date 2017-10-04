package com.htm.capgem.hmrc

class Bill {

  type Pounds = BigDecimal

  def calculateBill(items: List[String]): Pounds = {
    val MAX_SERVICE_CHARGE = 20
    val TEN_PERCENT = 1.10
    val TWENTY_PERCENT = 0.20
    var total: Pounds = 0
    var foodItem: Boolean = false
    var hotFoodItem: Boolean = false

    items.foreach(_ match {
      case "Cola" => total += 0.50
      case "Coffee" => total += 1.00
      case "Cheese Sandwich" => total += 2.00; foodItem = true
      case "Steak Sandwich" => total += 4.50; foodItem = true; hotFoodItem = true
      case _ => ()
    }
    )

    (foodItem, hotFoodItem) match {
      case (_, true) => {
        var serviceCharge: Pounds = total * TWENTY_PERCENT
        serviceCharge = if (serviceCharge > MAX_SERVICE_CHARGE) MAX_SERVICE_CHARGE else serviceCharge
        total += serviceCharge
      }
      case (true, false) => total *= TEN_PERCENT
      case (_, _) => ()
    }
    total
  }

}

object Bill extends Bill {
  def apply(orders: List[String]): Pounds = calculateBill(orders)
}