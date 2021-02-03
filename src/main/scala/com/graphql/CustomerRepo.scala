package com.graphql

case class Customer(
    id: Int,
    firstname: String,
    lastname: String
)

class CustomerRepo {
  import CustomerRepo._

  def getCustomerById(id: Int): Option[Customer] =
    customers.find(c => c.id == id)
  def getCustomers(): List[Customer] = customers
  def addCustomer(
      id: Int,
      firstname: String,
      lastname: String
  ): Option[Customer] = {
    val newCustomer = Customer(id, firstname, lastname)
    customers = newCustomer :: customers
    Some(newCustomer)
  }
}

object CustomerRepo {
  var customers = List(
    Customer(id = 1, firstname = "Weerayut", lastname = "Thinchamlong"),
    Customer(id = 10, firstname = "Harvey", lastname = "Milk"),
    Customer(id = 99, firstname = "Magaret", lastname = "Atwood")
  )
}
