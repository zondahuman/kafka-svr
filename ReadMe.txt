Kafka Version:
kafka_2.11-0.10.2.0


Update Follow Up:
broker.id=0
listeners=PLAINTEXT://172.16.2.146:9092
zookeeper.connect=172.16.2.146:2181





http://blog.csdn.net/molingduzun123/article/details/51785141


./kafka-topics.sh --create --zookeeper 172.16.2.146:2182 --replication-factor 3 --partitions 3 --topic attack_group


Produce Message：
 ./kafka-console-producer.sh --broker-list 172.16.2.146:9092,172.16.2.145:9092,172.16.2.134:9092 --topic attack_group
Consume Message：
./kafka-console-consumer.sh --zookeeper 172.16.2.146:2182--from-beginning --topic attack_group





