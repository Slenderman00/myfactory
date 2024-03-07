# Index
- [/api/address](#/api/address)
    - [api/address/all-by-city/{city}](#api/address/all-by-city/{city})
    - [api/address/all](#api/address/all)
    - [api/address/{id}](#api/address/{id})
    - [api/address/create](#api/address/create)
    - [api/address/update](#api/address/update)
    - [api/address/delete/{id}](#api/address/delete/{id})
- [/api/customer](#/api/customer)
    - [api/customer/all](#api/customer/all)
    - [api/customer/{id}](#api/customer/{id})
    - [api/customer/create-with-address](#api/customer/create-with-address)
    - [api/customer/create](#api/customer/create)
    - [api/customer/update](#api/customer/update)
    - [api/customer/delete/{id}](#api/customer/delete/{id})
- [/api/order](#/api/order)
    - [api/order/all](#api/order/all)
    - [api/order/{id}](#api/order/{id})
    - [api/order/create](#api/order/create)
    - [api/order/update](#api/order/update)
    - [api/order/delete/{id}](#api/order/delete/{id})
- [/api/machine](#/api/machine)
    - [api/machine/all](#api/machine/all)
    - [api/machine/{id}](#api/machine/{id})
    - [api/machine/create](#api/machine/create)
    - [api/machine/update](#api/machine/update)
    - [api/machine/delete/{id}](#api/machine/delete/{id})
- [/api/part](#/api/part)
    - [api/part/all](#api/part/all)
    - [api/part/{id}](#api/part/{id})
    - [api/part/create](#api/part/create)
    - [api/part/update](#api/part/update)
    - [api/part/delete/{id}](#api/part/delete/{id})
- [/api/subassembly](#/api/subassembly)
    - [api/subassembly/all](#api/subassembly/all)
    - [api/subassembly/{id}](#api/subassembly/{id})
    - [api/subassembly/create](#api/subassembly/create)
    - [api/subassembly/update](#api/subassembly/update)
    - [api/subassembly/delete/{id}](#api/subassembly/delete/{id})
# Documentation
## /api/address
Operations on addresses
### api/address/all-by-city/{city}
Fetch customers by city
- Method: GET
- Fields:
    - **street**
        - Type: java.lang.String
        - Street of the address
    - **city**
        - Type: java.lang.String
        - City of the address
    - **zipCode**
        - Type: java.lang.String
        - Zip code of the address
    - **country**
        - Type: java.lang.String
        - Country of the address
    - **customers**
        - Type: java.util.List
        - Customers of the address
    - **id**
        - Type: java.lang.Long
        - ID of the address
- Error: 🔥 Unable to resolve fields for interface: java.util.List
- Example:
```curl
curl -H "Content-type: application/json" 'http://127:0.0.1:8080/api/address/all-by-city/{city}'
```
### api/address/all
Get all addresses
- Method: GET
- Fields:
    - **street**
        - Type: java.lang.String
        - Street of the address
    - **city**
        - Type: java.lang.String
        - City of the address
    - **zipCode**
        - Type: java.lang.String
        - Zip code of the address
    - **country**
        - Type: java.lang.String
        - Country of the address
    - **customers**
        - Type: java.util.List
        - Customers of the address
    - **id**
        - Type: java.lang.Long
        - ID of the address
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/address/all?page=0&size=20&sort=street,asc'
```
### api/address/{id}
Get address by ID
- Method: GET
- Fields:
    - **street**
        - Type: java.lang.String
        - Street name
    - **city**
        - Type: java.lang.String
        - City name
    - **zipCode**
        - Type: java.lang.String
        - Zip code
    - **country**
        - Type: java.lang.String
        - Country name
    - **customers**
        - Type: java.util.List
        - Customers living at this address
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/address/{id}'
```
### api/address/create
Create address
- Method: POST
- Fields:
    - **street**
        - Type: java.lang.String
        - Street name
    - **city**
        - Type: java.lang.String
        - City name
    - **zipCode**
        - Type: java.lang.String
        - Zip code
    - **country**
        - Type: java.lang.String
        - Country name
    - **customers**
        - Type: java.util.List
        - Customers living at this address
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
- Example:
```curl
curl -X POST -H "Content-type: application/json" -d '{"street":"some street","city":"some city","zipCode":"some zip code","country":"some country"}' 'http://127.0.0.1:8080/api/address/create'
```
### api/address/update
Update address
- Method: PUT
- Fields:
    - **street**
        - Type: java.lang.String
        - Street name
    - **city**
        - Type: java.lang.String
        - City name
    - **zipCode**
        - Type: java.lang.String
        - Zip code
    - **country**
        - Type: java.lang.String
        - Country name
    - **customers**
        - Type: java.util.List
        - Customers living at this address
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/address/delete/{id}
Delete address by ID
- Method: DELETE
- Fields: None
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/address/delete/{id}'
```
## /api/customer
Operations on customers
### api/customer/all
Get all customers
- Method: GET
- Fields:
    - **firstName**
        - Type: java.lang.String
        - First name of the customer
    - **lastName**
        - Type: java.lang.String
        - Last name of the customer
    - **email**
        - Type: java.lang.String
        - Email of the customer
    - **phone**
        - Type: java.lang.String
        - Phone of the customer
    - **addresses**
        - Type: java.util.List
        - Addresses of the customer
    - **id**
        - Type: java.lang.Long
        - ID of the customer
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/customer/all?page=0&size=20&sort=firstName,asc'
```
### api/customer/{id}
Get customer by ID
- Method: GET
- Fields:
    - **name**
        - Type: java.lang.String
        - Customer's name
    - **surname**
        - Type: java.lang.String
        - Customer's surname
    - **email**
        - Type: java.lang.String
        - Customer's email address
    - **phone**
        - Type: java.lang.String
        - Customer's phone number
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/customer/create-with-address
Create customer with address (documentation is missing all address fields)
- Method: POST
- Fields:
    - **name**
        - Type: java.lang.String
        - Customer's name
    - **surname**
        - Type: java.lang.String
        - Customer's surname
    - **email**
        - Type: java.lang.String
        - Customer's email address
    - **phone**
        - Type: java.lang.String
        - Customer's phone number
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
    - **address**
        - Type: com.myfactory.myfactory.Entities.Address
        - Address of the customer
    - **street**
        - Type: java.lang.String
        - Street of the customer
    - **city**
        - Type: java.lang.String
        - City of the customer
    - **zipCode**
        - Type: java.lang.String
        - Zip code of the customer
    - **country**
        - Type: java.lang.String
        - Country of the customer
- Example:
```curl
curl -X POST -H "Content-type: application/json" -d '{"name":"some name","surname":"some surname","email":"some email","phone":"some phone","street":"some street","city":"some city","zipCode":"some zip code","country":"some country"}' 'http://127.0.0.1:8080/api/customer/create-with-address'
```
### api/customer/create
Create customer
- Method: POST
- Fields:
    - **name**
        - Type: java.lang.String
        - Customer's name
    - **surname**
        - Type: java.lang.String
        - Customer's surname
    - **email**
        - Type: java.lang.String
        - Customer's email address
    - **phone**
        - Type: java.lang.String
        - Customer's phone number
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/customer/update
Update customer
- Method: PUT
- Fields:
    - **name**
        - Type: java.lang.String
        - Customer's name
    - **surname**
        - Type: java.lang.String
        - Customer's surname
    - **email**
        - Type: java.lang.String
        - Customer's email address
    - **phone**
        - Type: java.lang.String
        - Customer's phone number
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/customer/delete/{id}
Delete customer by ID
- Method: DELETE
- Fields: None
## /api/order
Operations on orders
### api/order/all
Get all orders
- Method: GET
- Fields: None
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/order/all?page=0&size=20&sort=customer,asc'
```
### api/order/{id}
Get order by ID
- Method: GET
- Fields:
    - **machines**
        - Type: java.util.List
        - List of machines in this order
    - **customer**
        - Type: com.myfactory.myfactory.Entities.Customer
        - Customer who ordered this order
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/order/create
Create order
- Method: POST
- Fields:
    - **machines**
        - Type: java.util.List
        - List of machines in this order
    - **customer**
        - Type: com.myfactory.myfactory.Entities.Customer
        - Customer who ordered this order
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/order/update
Update order
- Method: PUT
- Fields:
    - **machines**
        - Type: java.util.List
        - List of machines in this order
    - **customer**
        - Type: com.myfactory.myfactory.Entities.Customer
        - Customer who ordered this order
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/order/delete/{id}
Delete order by ID
- Method: DELETE
- Fields: None
## /api/machine
Operations on machines
### api/machine/all
Get all machines
- Method: GET
- Fields: None
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/machine/all?page=0&size=20&sort=name,asc'
```
### api/machine/{id}
Get machine by ID
- Method: GET
- Fields:
    - **order**
        - Type: com.myfactory.myfactory.Entities.FactoryOrder
        - Order this machine is a part of
    - **subassemblies**
        - Type: java.util.List
        - List of subassemblies in this machine
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/machine/create
Create machine
- Method: POST
- Fields:
    - **order**
        - Type: com.myfactory.myfactory.Entities.FactoryOrder
        - Order this machine is a part of
    - **subassemblies**
        - Type: java.util.List
        - List of subassemblies in this machine
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/machine/update
Update machine
- Method: PUT
- Fields:
    - **order**
        - Type: com.myfactory.myfactory.Entities.FactoryOrder
        - Order this machine is a part of
    - **subassemblies**
        - Type: java.util.List
        - List of subassemblies in this machine
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/machine/delete/{id}
Delete machine by ID
- Method: DELETE
- Fields: None
## /api/part
Operations on parts
### api/part/all
Get all parts
- Method: GET
- Fields: None
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/part/all?page=0&size=20&sort=name,asc'
```
### api/part/{id}
Get part by ID
- Method: GET
- Fields:
    - **name**
        - Type: java.lang.String
        - Part's name
    - **description**
        - Type: java.lang.String
        - Part's description
    - **subassembly**
        - Type: com.myfactory.myfactory.Entities.Subassembly
        - Subassembly this part is a part of
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/part/create
Create part
- Method: POST
- Fields:
    - **name**
        - Type: java.lang.String
        - Part's name
    - **description**
        - Type: java.lang.String
        - Part's description
    - **subassembly**
        - Type: com.myfactory.myfactory.Entities.Subassembly
        - Subassembly this part is a part of
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/part/update
Update part
- Method: PUT
- Fields:
    - **name**
        - Type: java.lang.String
        - Part's name
    - **description**
        - Type: java.lang.String
        - Part's description
    - **subassembly**
        - Type: com.myfactory.myfactory.Entities.Subassembly
        - Subassembly this part is a part of
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/part/delete/{id}
Delete part by ID
- Method: DELETE
- Fields: None
## /api/subassembly
Operations on subassemblies
### api/subassembly/all
Get all subassemblies
- Method: GET
- Fields: None
- Error: 🔥 Unable to resolve fields for interface: org.springframework.data.domain.Page
- Example:
```curl
curl -H "Content-type: application/json" 'http://127.0.0.1:8080/api/subassembly/all?page=0&size=20&sort=name,asc'
```
### api/subassembly/{id}
Get subassembly by ID
- Method: GET
- Fields:
    - **name**
        - Type: java.lang.String
        - Subassembly's name
    - **description**
        - Type: java.lang.String
        - Subassembly's description
    - **machine**
        - Type: com.myfactory.myfactory.Entities.Machine
        - Machine this subassembly is a part of
    - **parts**
        - Type: java.util.List
        - List of parts in this subassembly
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/subassembly/create
Create subassembly
- Method: POST
- Fields:
    - **name**
        - Type: java.lang.String
        - Subassembly's name
    - **description**
        - Type: java.lang.String
        - Subassembly's description
    - **machine**
        - Type: com.myfactory.myfactory.Entities.Machine
        - Machine this subassembly is a part of
    - **parts**
        - Type: java.util.List
        - List of parts in this subassembly
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/subassembly/update
Update subassembly
- Method: PUT
- Fields:
    - **name**
        - Type: java.lang.String
        - Subassembly's name
    - **description**
        - Type: java.lang.String
        - Subassembly's description
    - **machine**
        - Type: com.myfactory.myfactory.Entities.Machine
        - Machine this subassembly is a part of
    - **parts**
        - Type: java.util.List
        - List of parts in this subassembly
    - **id**
        - Type: java.lang.Long
        - The unique identifier for this entity.
### api/subassembly/delete/{id}
Delete subassembly by ID
- Method: DELETE
- Fields: None
