# test-sangria-graphql-akka
## GraphQL Query `http//localhost:8080/customer`
### get customer by id
```
{
    customer(id: 1) {
        firstname
        lastname
    }
}
```
return
```
{
    "data": {
        "customer": {
            "id": 1,
            "firstname": "Weerayut",
            "lastname": "Thinchamlong"
        }
    }
}
```

### get all customer
```
{
    customers {
        firstname
        lastname
    }
}
```
return
```
{
    "data": {
        "customers": [
            {
                "firstname": "Weerayut",
                "lastname": "Thinchamlong"
            },
            {
                "firstname": "Harvey",
                "lastname": "Milk"
            },
            {
                "firstname": "Magaret",
                "lastname": "Atwood"
            }
        ]
    }
}
```
### add a new customer
```
{
    addCustomer(id: 2, firstname: "Taylor", lastname: "Swift") {
        id
        firstname
        lastname
    }
}
```
return
```
{
    "data": {
        "addCustomer": {
            "id": 2,
            "firstname": "Taylor",
            "lastname": "Swift"
        }
    }
}
```
