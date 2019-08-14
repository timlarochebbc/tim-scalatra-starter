package com.example.model

import java.util.Date

import scala.collection.mutable

object OrderDbStub {
  var x = "DB stub test"
  var db = collection.mutable.HashMap[Int, Order]()
  db.put(1, new Order(1, new Date(), "test"))
}
