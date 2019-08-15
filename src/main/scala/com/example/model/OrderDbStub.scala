package com.example.model

import java.util.Date

import scala.collection.mutable

object OrderDbStub {
  var x = "DB stub test"
  var db = collection.mutable.HashMap[Int, Order]()
}
