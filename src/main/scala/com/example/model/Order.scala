package com.example.model

import java.util.Date

import scala.collection.mutable.ArrayBuffer

class Order(val id: Int, val time: Date, val contents: ArrayBuffer[Product]) {

}
