package com.htm.capgem.hmrc

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ListBuffer

class BillSpec extends FlatSpec with Matchers{

  it should "take a list and return a total" in  {
   val items = List("Cola", "Coffee", "Cheese Sandwich")
    val total = Bill(items)
    total shouldBe 3.85
  }


  it should "take an empty list and return a total of zero" in  {
    val items = List()
    val total = Bill(items)
    total shouldBe 0.00
  }

  it should "take a list and return a total where items are not recognised should be " in  {
    val items = List("Cola", "Coffee", "Cheese Sandwich", "Dog poo")
    val total = Bill(items)
    total shouldBe 3.85
  }

  it should "apply no service charge for only drinks" in {
    val items = List("Cola", "Coffee")
    val total = Bill(items)
    total shouldBe 1.50
  }
  it should "apply 10% service charge for orders with cold food" in {
    val items = List("Cola", "Coffee", "Cheese Sandwich")
    val total = Bill(items)
    total shouldBe 3.85
  }

  it should "apply 20% service charge for orders with hot food" in {
    val items = List("Cola", "Coffee", "Steak Sandwich")
    val total = Bill(items)
    total shouldBe 7.20
  }
  it should "apply maximum 20 pounds service charge for orders with hot food where service charge would be over 20 ponds" in {

    var items = ListBuffer[String]()

    for(x <-  1 to 40)
      items += "Steak Sandwich"

    val total = Bill(items.toList)
    total shouldBe 200
  }
}
