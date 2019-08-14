package com.example.app

import java.util.Date

import com.example.model.{Order, OrderDbStub, ProductDbStub}
import com.fasterxml.jackson.databind.ObjectMapper
import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/") {
    views.html.home(ProductDbStub.db)
  }

  get("/order/:id"){
    println(OrderDbStub.db.get({params("id").toInt}).toString)
    views.html.order(OrderDbStub.db.get({params("id").toInt}).toString, {params(key = "id").toInt})
  }

  post("/neworder"){
    //Generate an id
    val date = new Date()
    val id = Math.abs(date.toString.hashCode)

    //Serialise object into JSON
    val objectMapper = new ObjectMapper()
    val order = new Order(id, date, "test")

    //Post into DB.
    println("date: " + date)
    println("id: " + id)
    println("order: " + order)

    OrderDbStub.db += id -> order
  }

  post("/testpost"){
    OrderDbStub.db += 3 -> new Order(999, new Date(), "test999")
  }
  //
}
