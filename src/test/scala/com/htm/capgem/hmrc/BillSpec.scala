package com.htm.capgem.hmrc

import org.scalatest.{FlatSpec, Matchers}

class BillSpec extends FlatSpec with Matchers{

  it should "take a list and return a total" in  {
   val items = List("Cola", "Coffee", "Cheese Sandwich")
    val total = Bill(items)
    total shouldBe 3.50
  }


  it should "take an empty list and return a total of zero" in  {
    val items = List()
    val total = Bill(items)
    total shouldBe 0.00
  }

  it should "take a list and return a total where items are not recognised should be " in  {
    val items = List("Cola", "Coffee", "Cheese Sandwich", "Dog poo")
    val total = Bill(items)
    total shouldBe 3.50
  }

}
