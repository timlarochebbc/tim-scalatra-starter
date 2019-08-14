package com.example.model

import scala.collection.mutable

object ProductDbStub {
  var db = new mutable.HashMap[Int, Product]()

  db += 1 -> new Product("Chicken Dish", 12)
  db += 2 -> new Product("Beef Dish", 13)
  db += 3 -> new Product("Pork Dish", 11)
  db += 4 -> new Product("Vegetarian Dish", 10)
  db += 5 -> new Product("Chicken Soup", 6)
  db += 6 -> new Product("Beef Soup", 7)
  db += 7 -> new Product("Pork Soup", 5)
  db += 8 -> new Product("Vegetarian Soup", 4)
  db += 9 -> new Product("Fries", 2)
  db += 10 -> new Product("Salad", 1)
}
