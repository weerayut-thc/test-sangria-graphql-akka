package com.graphql

import sangria.execution.deferred.{Fetcher, HasId}
import sangria.schema._
import sangria.macros.derive._

import scala.concurrent.Future

object SchemaDefinition {

  val customers = Fetcher.caching((ctx: CustomerRepo, ids: Seq[Int]) =>
    Future.successful(
      ids.flatMap(id => ctx.getCustomerById(id))
    )
  )(HasId(_.id))

  val Customer =
    deriveObjectType[CustomerRepo, Customer](
      ObjectTypeDescription("Agoda's customers")
    )

  val ID = Argument("id", IntType, description = "id of the customer")
  val FIRSTNAME =
    Argument("firstname", StringType, description = "firstname of the customer")
  val LASTNAME =
    Argument("lastname", StringType, description = "lastname of the customer")

  val Query = ObjectType(
    "Query",
    fields[CustomerRepo, Unit](
      Field(
        "customer",
        OptionType(Customer),
        arguments = ID :: Nil,
        resolve = ctx => ctx.ctx.getCustomerById(ctx arg ID)
      ),
      Field(
        "customers",
        ListType(Customer),
        arguments = Nil,
        resolve = ctx => ctx.ctx.getCustomers()
      ),
      Field(
        "addCustomer",
        OptionType(Customer),
        arguments = ID :: FIRSTNAME :: LASTNAME :: Nil,
        resolve = ctx =>
          ctx.ctx
            .addCustomer(ctx arg ID, ctx arg FIRSTNAME, ctx arg LASTNAME)
      )
    )
  )

  val CustomerSchema = Schema(Query)
}
