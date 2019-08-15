package com.example.test

import com.example.app.MyScalatraServlet
import com.example.model.OrderDbStub
import org.mockito.MockitoScalaSession
import org.scalatest.{FlatSpec, FlatSpecLike, FreeSpec, FunSuiteLike}
import org.scalatestplus.mockito.MockitoSugar
import org.scalatra.test.scalatest._

//  //Would this be more of an acceptance/feature test?
////  "An order than doesn't exist" should "return 404" in {
//}

class ScalatraServletTest extends ScalatraSuite with FlatSpecLike with MockitoSugar {

  addServlet(classOf[MyScalatraServlet], "/*")

  MockitoScalaSession().run{
    //val x = mock[OrderDbStub]
  }

  "GET /getcart" should "return 200" in {
    get("/getcart"){
      assert(status == 200)
    }
  }

  "Attempting to access an order that doesn't exit" should "return 404" in {
    get("/order/1"){
      assert(status == 404)
    }
  }
}
