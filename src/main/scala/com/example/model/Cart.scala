package com.example.model

import scala.collection.mutable.ArrayBuffer

object Cart {
  var items = ArrayBuffer[Product]()

  def emptyCart(): Unit ={
    items = new ArrayBuffer[Product]()
  }
}
