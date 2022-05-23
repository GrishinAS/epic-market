## Deployment notes
Deployment of the system performed with the help of following tools:
1. **Kubernetes** - online shop core service.
   * Minikube - desktop version for development. To run use "minikube start"
   * minikube service --url servicename - to enable port forward inside minukube
2. **skaffold** - Skaffold handles the workflow for building,
pushing and deploying your application.
   * ./skaffold.yml - file with deployment instructions. Deploy all applications at once.
3. **Helm** - Tool for kubernetes package management. Not used at the moment.
4. **GCP** - Google cloud
   * deployment/epic-market-kubeconfig - config for connection to gcp cluster from idea
5. **Kafka** - queue management<br>
In kafka.yml one can set up topics using KAFKA_CREATE_TOPICS env<br>
Zookeeper should be started before
   * kubectl apply -f kafka/zookeeper.yml
   * kubectl apply -f kafka/kafka.yml
6. **Flyway** - DB migrations.  Not used at the moment.



