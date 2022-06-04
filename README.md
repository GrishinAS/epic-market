# Epic Market.
Online c2c car parts shop, created as a pet project.
Microservice system deployed in Kubernetes consist of:
1. **seller-api** - Service for placing lots;
   * Placing lots by categories tree, uploads images of them.

2. **buyer-api** - Service for searching and buying lots.
   * Display information about registered lots;
   * Filters, search system;
   * Create a proposal for buying.

3. **payment-api** - Service for processing payments.
   * Should manage the order of buying process.
   * Kafka

4. **api-compositor** - web service that proxying requests and gathering information from services.
   * Probably will be replaced by an existing gateway.
5. **discovery-service** - service registry. Not used in kubernetes cluster.
   * Eureka, Ribbon, Feign.
6. **config-server** - config management service.
   * Spring cloud config server.
7. **logistic-api** - Service for logistic operations.
8. **file-storage** - Service for images storage.
   * Should delete images when a lot was sold;
   * Could be used to store any type of files.
