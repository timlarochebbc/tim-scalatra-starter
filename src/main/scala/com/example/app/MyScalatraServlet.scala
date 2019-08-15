package com.example.app

import java.util.Date

import com.example.model.{Cart, Order, OrderDbStub, ProductDbStub, Product}
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatra._

import scala.collection.mutable.ArrayBuffer

class MyScalatraServlet() extends ScalatraServlet {

  get("/") {
    views.html.home(ProductDbStub.db)
  }

  get("/order/:id"){
    try{
      val order = OrderDbStub.db(params("id").toInt)
      val objectMapper = new ObjectMapper()
      objectMapper.registerModule(DefaultScalaModule)
      val contentJson = objectMapper.writeValueAsString(order.contents)
      println(order.contents)
      views.html.order(order.id, contentJson)
    } catch{
      case _: Throwable => NotFound("Unable to find order.")
    }
  }

  put("/addtocart/:id"){
    Cart.items += ProductDbStub.db(params(key = "id").toInt)
  }

  put("/emptycart"){
    Cart.emptyCart()
  }

  post("/neworder"){
    //Generate an id
    val date = new Date()
    val id = Math.abs(date.toString.hashCode)

    //Serialise object into JSON
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)

    //Serialise object from JSON string to Scala Object
    try{
      val contents = objectMapper.readValue(request.body, classOf[ArrayBuffer[Product]])
      val order = new Order(id, date, contents)
      OrderDbStub.db += id -> order
      Cart.emptyCart()
      println(id)
      Ok(s"$id")
    }catch{
      case e: Throwable => e.printStackTrace
    }

  }

  get("/getcart"){
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    objectMapper.writeValueAsString(Cart.items)
  }
}
