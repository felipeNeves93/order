**Order Microservice**

* **Objective**
    * A simple microservice that aims to apply the concepts of messaging and communication between microservices
      utilizing
      Apache Kafka and Avro schemas.
    * It will receive an Order object by message from the [Store Microservice](https://github.com/felipeNeves93/store),
      convert and persist on a DynamoDB database


* **Stack**
    * Java 17+
    * Spring Boot 2.7.7
    * Apache Kafka
    * DynamoDB
    * Docker


* **Running the application**
    * To run the dynamoDB database, run the following command ***docker-compose -f dynamodb-compose.yml up -d***
      inside the *docker* folder
    * To run the kafka, broker and schema registry, run the following command
      ***docker-compose -f kafka-compose.yml up -d***
      inside the *docker* folder


* **Useful Commands**
    * **Create order-created topic:** *docker exec -it broker kafka-topics --bootstrap-server broker:9092 --create
      --topic order-created --partitions 3 -replication-factor 1* 
  
