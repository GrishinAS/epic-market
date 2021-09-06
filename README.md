# Epic Market.
Online shop, created as a pet project.
Microservice system deployed in Kubernetes consist of:
1. **crud-service** - online shop core service.
   * Contains normalized data, handles OLTP requests.
   * Spring Data, Hibernate, PostgreSQL

2. **read-api** - client readings service.
   * **read-api** store denormalized data for quick access because retrieving data from a normalized schema is too heavy.
   * Storing a list of products with the denormalized information in few languages. For example, if **crud-service** have 1 entry from **product** table related to 3 entries from **info** table in different languages then it should have 3 entries in **read-api** service with **info + parameters + description** in one of the languages.
   * Spring Data, Mongo/Cassandra?

3. **cqrs** - the process of data denormalization from **crud-service** to **read-api**.
   * Should have message queuing system
   * Kafka

4. **api-compositor** - web service that proxying requests and gathering information from services.
   * When the product is requested the main information is retrieved from the **read-api**, but the exchange rates are obtained from **crud-service** because they can't be cached for a long time.
   * Accepts a product id and language code. Concurrently requests info from **read-api** and exchange rate from **crud-service**. Converts the price according to the language code.
5. **discovery-service** - service registry.
   * Eureka, Ribbon, Feign
6. **config-server** - config management service.
   * Spring cloud config server

